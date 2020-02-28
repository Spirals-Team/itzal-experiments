/**
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.shop.catalog.web.object

import com.fasterxml.jackson.annotation.JsonInclude
import com.google.common.base.Optional
import groovy.transform.CompileStatic
import org.mayocat.configuration.general.GeneralSettings
import org.mayocat.rest.web.object.EntityModelWebObject
import org.mayocat.shop.catalog.configuration.shop.CatalogSettings
import org.mayocat.shop.catalog.model.Feature
import org.mayocat.shop.catalog.model.Product
import org.mayocat.shop.front.util.ContextUtils
import org.mayocat.shop.taxes.configuration.Rate
import org.mayocat.shop.taxes.configuration.TaxesSettings
import org.mayocat.theme.FeatureDefinition
import org.mayocat.theme.ThemeDefinition
import org.mayocat.theme.ThemeFileResolver
import org.mayocat.theme.TypeDefinition
import org.mayocat.url.EntityURLFactory

/**
 * @version $Id$
 */
@CompileStatic
class AbstractProductWebObject
{
    String title

    String description

    String url

    String slug

    Boolean onShelf

    @JsonInclude(JsonInclude.Include.NON_NULL)
    EntityModelWebObject model

    String template

    @JsonInclude(JsonInclude.Include.NON_NULL)
    PriceWebObject unitPrice

    @JsonInclude(JsonInclude.Include.NON_NULL)
    PriceWebObject unitPriceStartsAt

    @JsonInclude(JsonInclude.Include.NON_NULL)
    PriceWebObject unitPriceExclusiveOfTaxes

    @JsonInclude(JsonInclude.Include.NON_NULL)
    TaxesWebObject taxes

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String type

    // available -> for sale and in stock
    // not_for_sale
    // out_of_stock
    String availability

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<FeatureWebObject> availableFeatures

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<SelectedFeatureWebObject> selectedFeatures

    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<ProductVariantWebObject> variants

    Boolean hasVariants = false

    @Deprecated
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, Object> theme_addons

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map <String, Object> addons

    def withProduct(Product product, EntityURLFactory urlFactory, ThemeFileResolver themeFileResolver,
            CatalogSettings catalogSettings, GeneralSettings generalSettings, TaxesSettings taxesSettings)
    {
        title = ContextUtils.safeString(product.title)
        description = ContextUtils.safeHtml(product.description)
        url = urlFactory.create(product).path
        slug = product.slug
        onShelf = product.onShelf

        if (product.model.isPresent() && themeFileResolver.resolveModelPath(product.model.get()).isPresent()) {
            model = new EntityModelWebObject([
                    template: themeFileResolver.resolveModelPath(product.model.get()).get(),
                    slug: product.model.get()
            ])
            template = themeFileResolver.resolveModelPath(product.model.get()).get()
        } else {
            template = "product.html"
        }

        if (product.type.isPresent()) {
            type = product.type.get()
        }

        // Taxes
        BigDecimal vatRate = null
        if (product.vatRateId.isPresent()) {
            vatRate = taxesSettings.vat.value.otherRates.find({ Rate rate ->
                rate.id == product.vatRateId.get()
            })?.value
        }
        if (!vatRate) {
            vatRate = taxesSettings.vat.value.defaultRate
        }
        taxes = new TaxesWebObject()
        taxes.vatRate = vatRate

        // Prices
        if (product.unitPrice != null) {
            def locale = generalSettings.locales.mainLocale.value;
            def currency = catalogSettings.currencies.mainCurrency.value;

            // Calculate incl. price
            def priceInclusiveOfTaxes = product.unitPrice.multiply(BigDecimal.ONE.add(vatRate))

            unitPrice = new PriceWebObject()
            unitPrice.withPrice(priceInclusiveOfTaxes, currency, locale)

            unitPriceExclusiveOfTaxes = new PriceWebObject()
            unitPriceExclusiveOfTaxes.withPrice(product.unitPrice, currency, locale)
        }

        def inStock = true
        if (catalogSettings.productsSettings.stock.value) {
            // A stock is managed, check it
            if (!product.stock || product.stock <= 0) {
                inStock = false
            }
        }

        if (product.onShelf && product.unitPrice != null && inStock) {
            availability = "available"
        } else if (product.onShelf && product.unitPrice != null) {
            availability = "out_of_stock"
        } else {
            availability = "not_for_sale"
        }

        // NOTE: Product with variants might override the availability, it will check for individual variants stocks
        // when variants have the "stock" property set in theme.yml.
        // For the price, the variants might override it as well, as well as setting the "unitPriceStartsAt" when price
        // differs over the different variants
    }

    def withAddons(Map<String, Object> addons) {
        theme_addons = addons
        this.addons = addons
    }

    def withFeaturesAndVariants(List<Feature> allFeatures, List<Product> variants, Map<String, String> selectedFeaturesList,
            CatalogSettings catalogSettings, GeneralSettings generalSettings, TaxesSettings taxesSettings, Map<String, TypeDefinition> types)
    {
        if (!type || !types.containsKey(type)) {
            // For now only product with a type can have variants
            return false;
        }

        hasVariants = true
        availableFeatures = [];

        def productType = types.get(type);

        // 1. Create the list of selected features
        addSelectedFeatures(allFeatures, productType, selectedFeaturesList);

        // 2. Create the list of available features
        addAvailableFeatures(allFeatures, productType, selectedFeaturesList, variants)

        // 3. Create the list of variants

        def variantsWithFeaturesDefined = variants.findAll({ Product variant ->
            def foundVariants = variant.features.findAll({ UUID feat ->
                Feature feature = allFeatures.find({ Feature f -> feat == f.id })
                feature && (productType.features.containsKey(feature.feature)
                        && (productType.features.get(feature.feature).keys.size() == 0
                        || productType.features.get(feature.feature).keys.containsKey(feature.featureSlug)))
            })
            foundVariants.size() == variant.features.size()
        });

        def anyVariantAvailable = false
        def anyVariantForSale = false
        def priceDefinedByVariants = productType.variants.properties.indexOf("price") >= 0
        def stockDefinedByVariants = productType.variants.properties.indexOf("stock") >= 0
        def locale = generalSettings.locales.mainLocale.value;
        def currency = catalogSettings.currencies.mainCurrency.value;
        BigDecimal minPrice
        def atLeastOnePriceDiffers = false
        def vatRate = taxes?.vatRate
        if (vatRate == null) {
            throw new IllegalStateException("VAT rate must be defined before adding features and variants." +
                    "Call #withProduct before #withFeaturesAndVariants")
        }

        this.variants = []
        variantsWithFeaturesDefined.each({ Product variant ->
            def variantAvailability = availability
            if (priceDefinedByVariants && variant.unitPrice == null && unitPrice == null) {
                variantAvailability = "not_for_sale"
            } else {
                anyVariantForSale = true
                if (priceDefinedByVariants) {
                    if (minPrice && minPrice != variant.unitPrice) {
                        atLeastOnePriceDiffers = true
                    }
                    minPrice = minPrice ? minPrice.min(variant.unitPrice) : variant.unitPrice
                }
                if (stockDefinedByVariants) {
                    if (variant.stock && variant.stock > 0) {
                        variantAvailability = "available"
                        anyVariantAvailable = true
                    } else {
                        variantAvailability = "out_of_stock"
                    }
                }
            }
            List<ProductVariantFeatureWebObject> variantFeatures = []
            variant.features.findAll({ UUID feat ->
                Feature feature = allFeatures.find({ Feature f -> feat == f.id })
                variantFeatures << new ProductVariantFeatureWebObject([
                        feature: feature.feature,
                        slug: feature.featureSlug
                ])
            })
            PriceWebObject variantPriceIncl = null
            PriceWebObject variantPriceExcl = null
            if (variant.unitPrice) {
                variantPriceIncl = new PriceWebObject().
                        withPrice(variant.unitPrice.multiply(BigDecimal.ONE.add(vatRate)), currency, locale)
                variantPriceExcl : new PriceWebObject().withPrice(variant.unitPrice, currency, locale)
            }
            this.variants << new ProductVariantWebObject([
                    unitPrice: variantPriceIncl,
                    unitPriceExclusiveOfTaxes: variantPriceExcl,
                    title: variant.title,
                    slug: variant.slug,
                    availability: variantAvailability,
                    features: variantFeatures
            ])
        })

        // Override availability and price from product if necessary
        if (priceDefinedByVariants && !anyVariantForSale) {
            availability = "not_for_sale"
        } else if (priceDefinedByVariants && atLeastOnePriceDiffers) {
            unitPrice = null
            unitPriceStartsAt = new PriceWebObject()
            unitPriceStartsAt.withPrice(minPrice.multiply(BigDecimal.ONE.add(vatRate)), currency, locale)
        } else if (priceDefinedByVariants && minPrice) {
            unitPrice = new PriceWebObject()
            unitPrice.withPrice(minPrice.multiply(BigDecimal.ONE.add(vatRate)), currency, locale)
        }
        if (stockDefinedByVariants && anyVariantAvailable) {
            availability = "available"
        } else if (stockDefinedByVariants) {
            availability = "out_of_stock"
        }
    }

    private def addSelectedFeatures(List<Feature> all, TypeDefinition type, Map<String, String> selected)
    {
        if (selected != null && selected.size() > 0) {
            selectedFeatures = []
        }
        all.findAll({ Feature feature ->
            // Filter out features for which we don't have a definition or for which the key is not defined
            type.features.containsKey(feature.feature) &&
                    (type.features.get(feature.feature).keys.size() == 0 ||
                            type.features.get(feature.feature).keys.containsKey(feature.featureSlug))

        }).each({ Feature feature ->
            FeatureDefinition definition = type.features.get(feature.feature)

            if (selected.containsKey(feature.feature)
                    && selected.get(feature.feature) == feature.featureSlug)
            {
                // This is the selected feature for this key, we add it to the list of selected features
                selectedFeatures << new SelectedFeatureWebObject([
                        featureName: definition.name,
                        featureSlug: feature.feature,
                        title: feature.title,
                        slug: feature.featureSlug
                ])
            }
        })
    }

    private def addAvailableFeatures(List<Feature> all, TypeDefinition type, Map<String, String> selected,
            List<Product> variants)
    {
        for (feature in type.features.entrySet()) {
            if (!selected.containsKey(feature.key)) {

                def options = all.findAll({ Feature feat ->
                    feat.feature.equals(feature.key) && variants.any({ Product variant ->
                        // At least one variant must contains this feature
                        variant.features.any({ UUID id -> feat.id == id })
                    })
                })

                if (type.features.size() == 1) {
                    // If there is only one feature, sort the list of features according to the list of variants
                    options = variants.collect({ Product variant ->
                        options.find({ Feature feat -> variant.features.get(0) == feat.id })
                    })
                } else {
                    // TODO
                    // devise a strategy
                }

                options = options.collect({ Feature feat ->
                    boolean isAvailable = availability == "available"
                    if (type.variants.properties.indexOf("stock") >= 0) {
                        // Stock varies with variants, we check the variants availability
                        def variantsWithThisFeature = variants.findAll({ Product product ->
                            product.features.indexOf(feat.id) >= 0
                        })

                        isAvailable = variantsWithThisFeature.any({ Product variant ->
                            variant.stock != null && variant.stock > 0
                        })
                    }

                    new FeatureListItemWebObject([
                            availability: isAvailable ? "available" : "not_for_sale",
                            slug: feat.featureSlug,
                            title: feat.title,
                            url: url + (selected.size() > 0 ? "/" : "")
                                    + selected.keySet().collect { String key ->
                                key + "/" + selected.get(key)
                            }.join("/") + "/" + feat.feature + "/" + feat.featureSlug
                    ])
                })

                // Add the feature object
                availableFeatures << new FeatureWebObject([
                        slug: feature.key,
                        name: feature.value.name,
                        options: options
                ])
            }
        }
    }
}

/**
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.shop.catalog.api.v1.object

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.google.common.base.Optional
import groovy.transform.CompileStatic
import org.hibernate.validator.constraints.NotEmpty
import org.mayocat.configuration.PlatformSettings
import org.mayocat.image.model.Image
import org.mayocat.model.AddonGroup
import org.mayocat.rest.api.object.AddonGroupApiObject
import org.mayocat.rest.api.object.BaseApiObject
import org.mayocat.rest.api.object.ImageApiObject
import org.mayocat.theme.ThemeDefinition

import static org.mayocat.rest.api.object.AddonGroupApiObject.forAddonGroup
import static org.mayocat.rest.api.object.AddonGroupApiObject.toAddonGroupMap

/**
 * API object for a {@link org.mayocat.shop.catalog.model.Collection}
 *
 * @version $Id$
 */
@CompileStatic
class CollectionApiObject extends BaseApiObject
{
    // API object

    String slug;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String model;

    @NotEmpty
    String title;

    String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Long numberOfProducts = null;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, AddonGroupApiObject> addons

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, Object> _embedded

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, Object> _relationships;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<Locale, Map<String, Object>> _localized;

    // Helper builder methods

    def withCollection(org.mayocat.shop.catalog.model.Collection collection)
    {
        this.with {
            slug = collection.slug
            title = collection.title
            description = collection.description
            _localized = collection.localizedVersions
        }
    }

    def withProductCount(Long n)
    {
        numberOfProducts = n
    }

    @JsonIgnore
    def withProductRelationships(List<org.mayocat.shop.catalog.model.Product> products)
    {
        if (_relationships == null) {
            _relationships = [:]
        }

        List productRelationships = [];

        products.each({ org.mayocat.shop.catalog.model.Product product ->
            def link = "/api/products/${product.slug}"
            productRelationships << [
                    title: product.title,
                    slug: product.slug,
                    _links: [self: [href: link]],
                    _href: link
            ]
        })

        _relationships.products = productRelationships
    }

    @JsonIgnore
    def withEmbeddedImages(List<Image> images, UUID featuredImageId, String tenantPrefix)
    {
        if (_embedded == null) {
            _embedded = [:]
        }

        ImageApiObject featuredImage

        def List<ImageApiObject> imageApiObjectList = [];

        images.each({ Image image ->
            ImageApiObject imageApiObject = new ImageApiObject()
            imageApiObject.withImage(image, tenantPrefix)
            imageApiObject.featured = false

            if (image.attachment.id == featuredImageId) {
                featuredImage = imageApiObject
                imageApiObject.featured = true
            }
            imageApiObjectList << imageApiObject
        })

        _embedded.images = imageApiObjectList;

        if (featuredImage) {
            _embedded.featuredImage = featuredImage
        }
    }
    @JsonIgnore
    def withEmbeddedFeaturedImage(Image featuredImage, String tenantPrefix)
    {
        if (_embedded == null) {
            _embedded = [:]
        }

        def imageApiObject = new ImageApiObject()
        imageApiObject.withImage(featuredImage, tenantPrefix)
        imageApiObject.featured = true
        _embedded.featuredImage = imageApiObject
    }

    @JsonIgnore
    org.mayocat.shop.catalog.model.Collection toCollection(PlatformSettings platformSettings,
            Optional<ThemeDefinition> themeDefinition)
    {
        def collection = new org.mayocat.shop.catalog.model.Collection()
        collection.with {
            title = this.title
            description = this.description

            setModel this.model

            setLocalizedVersions this._localized
        }

        if (addons) {
            collection.addons = toAddonGroupMap(addons, platformSettings, themeDefinition)
        }

        collection
    }

    @JsonIgnore
    CollectionApiObject withAddons(Map<String, AddonGroup> entityAddons) {
        if (!addons) {
            addons = [:]
        }

        entityAddons.values().each({ AddonGroup addon ->
            addons.put(addon.group, forAddonGroup(addon))
        })

        this
    }
}

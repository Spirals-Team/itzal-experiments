/**
 * Copyright (c) 2012, Mayocat <hello@mayocat.org>
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.mayocat.shop.catalog.web.object

import groovy.transform.CompileStatic
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import org.joda.money.format.MoneyAmountStyle
import org.joda.money.format.MoneyFormatter
import org.joda.money.format.MoneyFormatterBuilder

import java.math.RoundingMode

/**
 * Web object for a price representation. Contains the amount formatted according to a passed locale and a currency
 * representation.
 *
 * @version $Id$
 */
@CompileStatic
class PriceWebObject
{
    /**
     * Amount, rounded according to the currency number of decimals
     */
    String amount

    /**
     * Same as amount, truncated when the decimals part is zero (i.e. : 4 instead of 4.00)
     */
    String amountCompact

    /**
     * Amount without any rounding
     */
    String amountFull

    CurrencyWebObject currency;

    PriceWebObject withPrice(BigDecimal price, Currency priceCurrency, Locale locale)
    {
        MoneyFormatter formatter = new MoneyFormatterBuilder().appendAmount(MoneyAmountStyle.of(locale)).toFormatter();

        CurrencyUnit currencyUnit = CurrencyUnit.of(priceCurrency);
        amount = formatter.withLocale(locale).print(Money.of(currencyUnit, price, RoundingMode.HALF_EVEN));

        currency = new CurrencyWebObject();
        currency.withCurrency(priceCurrency, locale)

        if (price.doubleValue() == price.intValue()) {
            amountCompact = "" + price.intValue();
        } else {
            amountCompact = amount;
        }

        amountFull = price.toString()

        this
    }
}

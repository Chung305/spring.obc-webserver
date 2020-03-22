package com.github.curriculeon.models.workopportunity.convertablecurrency;

import com.github.curriculeon.models.workopportunity.convertablecurrency.CurrencyType;

public interface ConvertableCurrency {
    default Double convert(CurrencyType currencyType) {
        return Double.MAX_VALUE;
    }
}

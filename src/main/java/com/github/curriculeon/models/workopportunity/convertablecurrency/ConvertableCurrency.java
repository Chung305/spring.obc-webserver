package com.github.curriculeon.models.workopportunity.convertablecurrency;

public interface ConvertableCurrency {
    default Double convert(CurrencyType currencyType) {
        return Double.MAX_VALUE;
    }
}

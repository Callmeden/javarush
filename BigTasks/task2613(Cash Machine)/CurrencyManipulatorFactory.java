package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        String upperCaseCurrencyCode = currencyCode.toUpperCase();
        if (!map.containsKey(upperCaseCurrencyCode))
            map.put(upperCaseCurrencyCode, new CurrencyManipulator(upperCaseCurrencyCode));
        return map.get(upperCaseCurrencyCode);
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}

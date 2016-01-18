package com.bjorn.MakeChange;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MakeChange implements IMakeChange {

    private static final Map<String, Integer> CoinValueMap;
    static
    {
        CoinValueMap = new LinkedHashMap<String, Integer>();
        CoinValueMap.put("H", 50);
        CoinValueMap.put("Q", 25);
        CoinValueMap.put("D", 10);
        CoinValueMap.put("N", 5);
        CoinValueMap.put("P", 1);
    }

    public HashMap<String, Integer> makeChange(int cashTendered) {
        if(cashTendered < 0 ) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> coinAmountHashMap = new HashMap<String, Integer>();
        for (String key : CoinValueMap.keySet()) {
            while (cashTendered >= CoinValueMap.get(key)){
                coinAmountHashMap.put(key, coinAmountHashMap.getOrDefault(key, 0) + 1);
                cashTendered -= CoinValueMap.get(key);
            }
        }
        return coinAmountHashMap;
    }
}
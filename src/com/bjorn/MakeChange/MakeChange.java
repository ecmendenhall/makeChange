package com.bjorn.MakeChange;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bjornjohnson on 1/5/16.
 */

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

    public void updateHash(String cointType, HashMap<String, Integer> coinAmountHashMap, int coinValue, int cashTendered) {
        int temp = 0;
        if (coinAmountHashMap.get(cointType) != null) {
            temp = coinAmountHashMap.get(cointType);
        }
        coinAmountHashMap.put(cointType, temp + 1);
    }

    public HashMap<String, Integer> makeChange(int cashTendered) {
        if(cashTendered < 0 ) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> coinAmountHashMap = new HashMap<String, Integer>();
        for (String key : CoinValueMap.keySet()) {
            while (cashTendered >= CoinValueMap.get(key)){
                updateHash(key, coinAmountHashMap, CoinValueMap.get(key), cashTendered);
                cashTendered -= CoinValueMap.get(key);
            }
        }
        return coinAmountHashMap;
    }
}
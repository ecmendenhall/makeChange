package com.bjorn.MakeChange;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MakeChange implements IMakeChange {

    private static final Map<String, Integer> CoinValueMap;
    static
    {
        CoinValueMap = new LinkedHashMap<>();
        CoinValueMap.put("H", 50);
        CoinValueMap.put("Q", 25);
        CoinValueMap.put("D", 10);
        CoinValueMap.put("N", 5);
        CoinValueMap.put("P", 1);
    }

    private void addingACoin(String coinToAdd,  HashMap<String, Integer> expectedChange){
        expectedChange.put(coinToAdd, expectedChange.getOrDefault(coinToAdd, 0) + 1);
    }

    public HashMap<String, Integer> makeChange(int cashTendered) {
        if(cashTendered < 0 ) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> expectedChange = new HashMap<>();
        for (String coinToAdd : CoinValueMap.keySet()) {
            while (cashTendered >= CoinValueMap.get(coinToAdd)){
                addingACoin(coinToAdd, expectedChange);
                cashTendered -= CoinValueMap.get(coinToAdd);
            }
        }
        return expectedChange;
    }
}
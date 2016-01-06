package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/5/16.
 */

public class MakeChange implements IMakeChange {

    public void updateHash(char cointType, HashMap<Character, Integer> coinAmountHashMap, int coinValue, int cashTendered) {
        int temp = 0;
        if (coinAmountHashMap.get(cointType) != null) {
            temp = coinAmountHashMap.get(cointType);
        }
        coinAmountHashMap.put(cointType, temp + 1);
    }

    public HashMap<Character, Integer> makeChange(int cashTendered) {
        if(cashTendered < 0 ) {
            throw new IllegalArgumentException();
        }
        HashMap<Character, Integer> coinAmountHashMap = new HashMap<Character, Integer>();
        int temp = 0;

        while (cashTendered > 0) {

            if (cashTendered >= 50){
                updateHash('H', coinAmountHashMap, 50, cashTendered);
                cashTendered -= 50;
            }
            else if (cashTendered >= 25){
                updateHash('Q', coinAmountHashMap, 25, cashTendered);
                cashTendered -= 25;
            }
            else if (cashTendered >= 10){
                updateHash('D', coinAmountHashMap, 10, cashTendered);
                cashTendered -= 10;
            }
            else if (cashTendered >= 5){
                updateHash('N', coinAmountHashMap, 5, cashTendered);
                cashTendered -= 5;
            }
            else {
                updateHash('P', coinAmountHashMap, 1, cashTendered);
                cashTendered--;
            }

        }
        return coinAmountHashMap;
    }
}

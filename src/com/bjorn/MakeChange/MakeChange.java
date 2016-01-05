package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/5/16.
 */
public class MakeChange {

    private void updateHash(char cointType, HashMap<Character, Integer> hmap, int coinValue, int cashTendered) {
        int temp = 0;
        if (hmap.get(cointType) != null) {
            temp = hmap.get(cointType);
        }
        hmap.put(cointType, temp + 1);
    }

    public HashMap<Character, Integer> makeChange(int cashTendered) {
        if(cashTendered < 0) {
            throw new IllegalArgumentException();
        }
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        int temp = 0;

        while (cashTendered > 0) {

            if (cashTendered >= 50){
                updateHash('H', hmap, 50, cashTendered);
                cashTendered -= 50;
            }
            else if (cashTendered >= 25){
                updateHash('Q', hmap, 25, cashTendered);
                cashTendered -= 25;
            }
            else if (cashTendered >= 10){
                updateHash('D', hmap, 10, cashTendered);
                cashTendered -= 10;
            }
            else if (cashTendered >= 5){
                updateHash('N', hmap, 5, cashTendered);
                cashTendered -= 5;
            }
            else {
                updateHash('P', hmap, 1, cashTendered);
                cashTendered--;
            }

        }
        return hmap;
    }
}

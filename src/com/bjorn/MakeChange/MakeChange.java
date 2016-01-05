package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/5/16.
 */
public class MakeChange {

    public HashMap<Character, Integer> makeChange(int cashTendered) {
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        int temp = 0;

        while (cashTendered > 0) {


            if (cashTendered >= 10){
                temp = 0;
                if (hmap.get('D') != null) {
                    temp = hmap.get('D');
                }
                hmap.put('D', temp + 1);
                cashTendered -= 10;
            }
            else if (cashTendered >= 5){
                temp = 0;
                if (hmap.get('N') != null) {
                    temp = hmap.get('N');
                }
                hmap.put('N', temp + 1);
                cashTendered -= 5;
            }
            else {
                temp = 0;
                if (hmap.get('P') != null) {
                    temp = hmap.get('P');
                }
                hmap.put('P', temp + 1);
                cashTendered--;
            }


        }
        return hmap;
    }
}

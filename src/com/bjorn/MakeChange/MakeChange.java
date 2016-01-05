package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/5/16.
 */
public class MakeChange {

    public HashMap<Character, Integer> makeChange(int cashTendered) {
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

//        if(cashTendered == 0) {
//            return hmap;
//        }
        while (cashTendered > 0) {
            if(cashTendered == 0){
                return hmap;
            }
            else if(cashTendered < 5){
                int temp = 0;
                if (hmap.get('P') != null) {
                    temp = hmap.get('P');
                }
                hmap.put('P', temp + 1);
                cashTendered--;
            }
            else {
                return hmap;
            }

        }
        return hmap;
    }
}

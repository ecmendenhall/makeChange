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
        switch (cashTendered) {
            case 0: return hmap;
            case 1: hmap.put('P', 1);
        }

        return hmap;
    }
}

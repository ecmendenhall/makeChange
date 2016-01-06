package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/6/16.
 */
public interface IMakeChange {
    void updateHash(char cointType, HashMap<Character, Integer> hmap, int coinValue, int cashTendered);

    HashMap<Character, Integer> makeChange(int cashTendered);
}

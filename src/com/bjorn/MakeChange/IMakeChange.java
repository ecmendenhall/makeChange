package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/6/16.
 */
public interface IMakeChange {
    void updateHash(String cointType, HashMap<String, Integer> hmap, int coinValue, int cashTendered);

    HashMap<String, Integer> makeChange(int cashTendered);
}

package com.bjorn.MakeChange;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/6/16.
 */
public interface IMakeChange {

    HashMap<String, Integer> makeChange(int cashTendered);
}

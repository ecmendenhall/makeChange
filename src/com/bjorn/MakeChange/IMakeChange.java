package com.bjorn.MakeChange;

import java.util.HashMap;

public interface IMakeChange {

    HashMap<String, Integer> makeChange(int cashTendered);
}

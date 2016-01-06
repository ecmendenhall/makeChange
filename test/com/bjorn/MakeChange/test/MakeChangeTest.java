package com.bjorn.MakeChange.test;

import com.bjorn.MakeChange.MakeChange;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * Created by bjornjohnson on 1/5/16.
 */
public class MakeChangeTest {

    private MakeChange makeChange;
    private HashMap<String, Integer> coinAmountHashMap;

    @Before
    public void setUp() {
        makeChange = new MakeChange();
        coinAmountHashMap = new HashMap<String, Integer>();
    }

    @Test
    public void testInstanceOf() {
        assertThat(makeChange, instanceOf(MakeChange.class));
    }

    @Test
    public void testZeroCurrency() {
        assertEquals(coinAmountHashMap, makeChange.makeChange(0));
    }

    @Test
    public void testOneCent() {
        coinAmountHashMap.put("P", 1);
        assertEquals(coinAmountHashMap, makeChange.makeChange(1));
    }

    @Test
    public void testFourCents() {
        coinAmountHashMap.put("P", 4);
        assertEquals(coinAmountHashMap, makeChange.makeChange(4));
    }

    @Test
    public void testFiveCents() {
        coinAmountHashMap.put("N", 1);
        assertEquals(coinAmountHashMap, makeChange.makeChange(5));
    }

    @Test
    public void testNineCents() {
        coinAmountHashMap.put("P", 4);
        coinAmountHashMap.put("N", 1);
        assertEquals(coinAmountHashMap, makeChange.makeChange(9));
    }

    @Test
    public void testTenCents() {
        coinAmountHashMap.put("D", 1);
        assertEquals(coinAmountHashMap, makeChange.makeChange(10));
    }

    @Test
    public void testSeventeenCents() {
        coinAmountHashMap.put("D", 1);
        coinAmountHashMap.put("N", 1);
        coinAmountHashMap.put("P", 2);
        assertEquals(coinAmountHashMap, makeChange.makeChange(17));
    }

    @Test
    public void testTwentyFiveCents() {
        coinAmountHashMap.put("Q", 1);
        assertEquals(coinAmountHashMap, makeChange.makeChange(25));
    }

    @Test
    public void testFourtyThreeCents() {
        coinAmountHashMap.put("Q", 1);
        coinAmountHashMap.put("D", 1);
        coinAmountHashMap.put("N", 1);
        coinAmountHashMap.put("P", 3);
        assertEquals(coinAmountHashMap, makeChange.makeChange(43));
    }

    @Test
    public void testFiftyCents() {
        coinAmountHashMap.put("H", 1);
        assertEquals(coinAmountHashMap, makeChange.makeChange(50));
    }

    @Test
    public void testNinetySevenCents() {
        coinAmountHashMap.put("H", 1);
        coinAmountHashMap.put("Q", 1);
        coinAmountHashMap.put("D", 2);
        coinAmountHashMap.put("P", 2);
        assertEquals(coinAmountHashMap, makeChange.makeChange(97));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForNegativeNumbers() {
        makeChange.makeChange(-1);
    }

}

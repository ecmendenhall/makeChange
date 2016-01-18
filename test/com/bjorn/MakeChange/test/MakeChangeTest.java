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
    private HashMap<String, Integer> expectedChange;

    @Before
    public void setUp() {
        makeChange = new MakeChange();
        expectedChange = new HashMap<>();
    }

    @Test
    public void testInstanceOf() {
        assertThat(makeChange, instanceOf(MakeChange.class));
    }

    @Test
    public void testZeroCurrency() {
        assertEquals(expectedChange, makeChange.makeChange(0));
    }

    @Test
    public void testOneCent() {
        expectedChange.put("P", 1);
        assertEquals(expectedChange, makeChange.makeChange(1));
    }

    @Test
    public void testFourCents() {
        expectedChange.put("P", 4);
        assertEquals(expectedChange, makeChange.makeChange(4));
    }

    @Test
    public void testFiveCents() {
        expectedChange.put("N", 1);
        assertEquals(expectedChange, makeChange.makeChange(5));
    }

    @Test
    public void testNineCents() {
        expectedChange.put("P", 4);
        expectedChange.put("N", 1);
        assertEquals(expectedChange, makeChange.makeChange(9));
    }

    @Test
    public void testTenCents() {
        expectedChange.put("D", 1);
        assertEquals(expectedChange, makeChange.makeChange(10));
    }

    @Test
    public void testSeventeenCents() {
        expectedChange.put("D", 1);
        expectedChange.put("N", 1);
        expectedChange.put("P", 2);
        assertEquals(expectedChange, makeChange.makeChange(17));
    }

    @Test
    public void testTwentyFiveCents() {
        expectedChange.put("Q", 1);
        assertEquals(expectedChange, makeChange.makeChange(25));
    }

    @Test
    public void testFourtyThreeCents() {
        expectedChange.put("Q", 1);
        expectedChange.put("D", 1);
        expectedChange.put("N", 1);
        expectedChange.put("P", 3);
        assertEquals(expectedChange, makeChange.makeChange(43));
    }

    @Test
    public void testFiftyCents() {
        expectedChange.put("H", 1);
        assertEquals(expectedChange, makeChange.makeChange(50));
    }

    @Test
    public void testNinetySevenCents() {
        expectedChange.put("H", 1);
        expectedChange.put("Q", 1);
        expectedChange.put("D", 2);
        expectedChange.put("P", 2);
        assertEquals(expectedChange, makeChange.makeChange(97));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForNegativeNumbers() {
        makeChange.makeChange(-1);
    }

}

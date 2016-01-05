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
    private HashMap<Character, Integer> hmap;

    @Before
    public void setUp() {
        makeChange = new MakeChange();
        hmap = new HashMap<Character, Integer>();
    }


    @Test
    public void testInstanceOf() {
        assertThat(makeChange, instanceOf(MakeChange.class));
    }

    @Test
    public void testZeroCurrency() {
        assertEquals(hmap, makeChange.makeChange(0));
    }

    @Test
    public void testOneCent() {
        hmap.put('P', 1);
        assertEquals(hmap, makeChange.makeChange(1));
    }

    @Test
    public void testFourCents() {
        hmap.put('P', 4);
        assertEquals(hmap, makeChange.makeChange(4));
    }

    @Test
    public void testFiveCents() {
        hmap.put('N', 1);
        assertEquals(hmap, makeChange.makeChange(5));
    }

    @Test
    public void testNineCents() {
        hmap.put('P', 4);
        hmap.put('N', 1);
        assertEquals(hmap, makeChange.makeChange(9));
    }

    @Test
    public void testTenCents() {
        hmap.put('D', 1);
        assertEquals(hmap, makeChange.makeChange(10));
    }

    @Test
    public void testSeventeenCents() {
        hmap.put('D', 1);
        hmap.put('N', 1);
        hmap.put('P', 2);
        assertEquals(hmap, makeChange.makeChange(17));
    }

    @Test
    public void testTwentyFiveCents() {
        hmap.put('Q', 1);
        assertEquals(hmap, makeChange.makeChange(25));
    }
}

package com.example.android.myandroidlibrary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{
    @Test
    public void addition_isCorrect1() throws Exception{
        assertEquals("expected: ",4,3+2);
    }
    @Test
    public void addition_isCorrect2() throws Exception{
        assertEquals("expected: ",4,2+2);
    }
    @Test
    public void addition_isCorrect3() throws Exception{
        assertEquals("expected: ",4,5+2);
    }
}
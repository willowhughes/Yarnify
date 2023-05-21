package com.AlexUtils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlexRetrofitTest {

    @Test
    public void retrofitcall() {
        AlexRetrofit alexRetrofit = new AlexRetrofit();
        assertEquals("TestString", alexRetrofit.Retrofitcall().getPattern());
    }
}
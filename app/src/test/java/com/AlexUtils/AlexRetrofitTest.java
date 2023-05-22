package com.AlexUtils;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlexRetrofitTest {


    /*IMPORTANT for this test

        This test uses Mocky.io to replicate a very simple API call.
        Mocky.io stores data locally on your browser. If you want to test this you'll have to
        create the same Mocky.io object and change the address within AlexRetrofit class.

     */
    @Test
    public void retrofitcall() {
        AlexRetrofit alexRetrofit = new AlexRetrofit();

        //This test fails on purpose. Changing the "TestString" to the value within the API response
        // will let it succeed. Expected is actually "This is a JSON with an array of JSON objects"
        //
        assertEquals("This is a JSON with an array of JSON objects", alexRetrofit.Retrofitcall().getPatternListClass());
    }
}
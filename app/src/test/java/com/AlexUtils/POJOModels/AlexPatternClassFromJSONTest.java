package com.AlexUtils.POJOModels;

import static org.junit.Assert.*;

import com.AlexUtils.AlexRetrofit;

import org.junit.Test;

import java.util.ArrayList;

//Testing Ravelry API method
// https://api.ravelry.com/patterns.json?ids=1335913
// with headers
// "Authorization: Basic cmVhZC1lZTgzYjdmMWNlMmE0ZjQ1YWFmOGQxYTkwNzUwMGM2ZDpWWUFRc0M4VTYyN1ZUNUl1UHY5eS9ZdVFEVWJIUVpTL1h0aXFJNVRi",
//            "Cookie: ravelrys_pocketses=eyJzZXNzaW9uX2lkIjoiOTgyNGRjZjZhN2Q1NmEzYmU4NmZiZDAwZjI0MjY4NGQiLCJfY3NyZl90b2tlbiI6InFaMlNsQmlMVWtsc0h4Vkx2c0pPQUFWcWVrUXdxMzhicVpWOFpQU0VRbEU9In0%3D--35f2bd3c7c52032a0d378a78ff2c703d0a2ad47a"})
//
public class AlexPatternClassFromJSONTest {

    @Test
    public void retroRavCall() {

        AlexRetrofit alexRetrofit = new AlexRetrofit();


        //assertEquals("testString3", alexRetrofit.RetrofitRavelryVersion().getPatterns().get(0).id);
        assertNotNull(alexRetrofit.RetrofitRavelryVersion());
    }

}
package com.AlexUtils;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.icu.util.VersionInfo;

import com.android.volley.toolbox.StringRequest;
import com.example.yarnify.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AlexUtilsTest {

    @Mock
    Context mContext;
    @Mock
    PackageManager mPackageManager;
    @Mock
    PackageInfo packageInfo;


    @Before
    public void setup() throws PackageManager.NameNotFoundException {
        MockitoAnnotations.openMocks(this);
        when(mContext.getPackageManager()).thenReturn(mPackageManager);
        when(mContext.getPackageName()).thenReturn(packageInfo.packageName);
        when(mContext.getPackageManager().getPackageInfo(packageInfo.packageName, 0)).thenReturn(packageInfo);
    }


    @Test
    public void AlexUtils() {

    }

    @Test
    public void apiQueryTestMethod() {

        AlexUtils alexUtils = new AlexUtils(mContext);
        String expected = "This is expected";

        assertEquals(expected, alexUtils.jsonResponse);

    }

    @Test
    public void addToResponseQueue() {
    }
}
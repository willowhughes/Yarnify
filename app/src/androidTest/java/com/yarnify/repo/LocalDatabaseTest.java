package com.yarnify.repo;


import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.utils.LiveDataTestUtil;
import com.yarnify.model.User;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class LocalDatabaseTest extends TestCase {

    //https://proandroiddev.com/testing-the-un-testable-and-beyond-with-android-architecture-components-part-1-testing-room-4d97dec0f451
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private LocalDatabase db;
    private UserDAO userDAO;

    @Before
    public void createDb() throws Exception{
        Context context = ApplicationProvider.getApplicationContext();

        db = Room.inMemoryDatabaseBuilder(context, LocalDatabase.class)
                .allowMainThreadQueries()
                .build();
        userDAO = db.userDAO();
    }

    @After
    public void closeDb() throws IOException{
        db.close();
    }

    @Test
    public void writeUserAndGetById() throws Exception{
        User judy = new User("Judy", "helloJudy");
        long userId = userDAO.addUser(judy);

        assertEquals(userId, LiveDataTestUtil.getValue(userDAO.getUser(userId)).getId());
        assertEquals(judy.getUsername(), LiveDataTestUtil.getValue(userDAO.getUser(userId)).getUsername());
        assertEquals(judy.getRavelryUsername(), LiveDataTestUtil.getValue(userDAO.getUser(userId)).getRavelryUsername());
    }
}
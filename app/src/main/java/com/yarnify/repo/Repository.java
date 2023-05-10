package com.yarnify.repo;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Repository {
    private static Repository mRepository;
    private final UserDAO mUserDAO;
    private final YarnDAO mYarnDAO;
    private final NeedleDAO mNeedleDAO;

    //LiveData automatically uses a thread, so the ExecutorService will be used to insert/update/delete
    private static final ExecutorService mDatabaseExecutor =
            Executors.newFixedThreadPool(4);

    public static Repository getInstance(Context context){
        if (mRepository == null){
            mRepository = new Repository(context);
        }
        return mRepository;
    }

    private Repository(Context context){
        LocalDatabase database = Room.databaseBuilder(context, LocalDatabase.class, "yarnify.db")
                .build();

        mUserDAO = database.userDAO();
        mYarnDAO = database.yarnDAO();
        mNeedleDAO = database.needleDAO();
    }

}

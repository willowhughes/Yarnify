package com.yarnify.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.yarnify.model.User;
import com.yarnify.model.Yarn;

import java.util.List;
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

    public static Repository getInstance(Context context) {
        if (mRepository == null) {
            mRepository = new Repository(context);
        }
        return mRepository;
    }

    private Repository(Context context) {
        LocalDatabase database = Room.databaseBuilder(context, LocalDatabase.class, "yarnify.db")
                .build();

        mUserDAO = database.userDAO();
        mYarnDAO = database.yarnDAO();
        mNeedleDAO = database.needleDAO();
    }

    //User Table: addUser, getUser, updateUser
    public void addUser(User user) {
        mDatabaseExecutor.execute(() -> {
            long userId = mUserDAO.addUser(user);
            user.setId(userId);
        });
    }

    public LiveData<User> getUser(long userId) {
        return mUserDAO.getUser(userId);
    }

    public void updateUser(User user) {
        mDatabaseExecutor.execute(() -> {
            mUserDAO.updateUser(user);
        });
    }

    //Yarn Table: getYarn, getYarns, addYarn, updateYarn deleteYarn
    //TODO: getYarnsOrderBy(String orderChoice)
    public LiveData<Yarn> getYarn(long yarnId) {
        return mYarnDAO.getYarn(yarnId);
    }

    public LiveData<List<Yarn>> getYarns() {
        return mYarnDAO.getYarns();
    }

    public void addYarn(Yarn yarn) {
        mDatabaseExecutor.execute(() -> {
            mYarnDAO.addYarn(yarn);
        });
    }

    public void updateYarn(Yarn yarn) {
        mDatabaseExecutor.execute(() -> {
            mYarnDAO.updateYarn(yarn);
        });
    }


    public void deleteYarn(Yarn yarn) {
        mDatabaseExecutor.execute(() -> {
            mYarnDAO.deleteYarn(yarn);
        });
    }

    public void deleteYarn(long id) {
        mDatabaseExecutor.execute(() -> {
            mYarnDAO.deleteYarn(id);
        });
    }
}

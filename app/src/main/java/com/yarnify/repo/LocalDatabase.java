package com.yarnify.repo;

import androidx.room.RoomDatabase;

import com.yarnify.model.NeedleModel;
import com.yarnify.model.UserModel;
import com.yarnify.model.YarnModel;

@androidx.room.Database( entities = { UserModel.class, YarnModel.class, NeedleModel.class }, version = 1,
        exportSchema = false )
abstract class LocalDatabase extends RoomDatabase {

    public abstract UserDAO userDAO();
    public abstract YarnDAO yarnDAO();
    public abstract NeedleDAO needleDAO();
}

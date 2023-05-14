package com.yarnify.repo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.yarnify.model.User;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User WHERE id = :id")
    LiveData<User> getUser(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long addUser(User user);

    @Update
    void updateUser(User user);

}

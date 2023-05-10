package com.yarnify.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserModel {

    //TABLE COLUMNS
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    private String mUsername;

    @ColumnInfo(name="updated")
    private long mUpdateTime;

    @ColumnInfo(name="ravelryUsername")
    private String mRavelryUsername;

    //CONSTRUCTOR
    public UserModel(@NonNull String username, String ravelryUsername){
        mUsername = username;
        mRavelryUsername = ravelryUsername;
        mUpdateTime = System.currentTimeMillis();
    }

    //GETTERS AND SETTERS
    public String getUsername() {
        return mUsername;
    }
    public void setUsername(String username) {
        this.mUsername = username;
    }

    public long getUpdateTime() { return  mUpdateTime; }
    public void setUpdateTime(long updateTime){ this.mUpdateTime = updateTime; }

    public String getRavelryUsername() { return mRavelryUsername; }
    public void setRavelryUsername(String ravelryUsername) {
        this.mRavelryUsername = ravelryUsername;
    }
}

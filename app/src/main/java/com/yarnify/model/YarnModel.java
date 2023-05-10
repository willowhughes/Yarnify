package com.yarnify.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class YarnModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public long mId;
}

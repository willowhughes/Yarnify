package com.yarnify.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pattern implements Parcelable {

    //TABLE COLUMNS
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name="updated")
    private long mUpdateTime;

    @ColumnInfo(name="image")
    private int mImageResource;

    @NonNull
    @ColumnInfo(name="title")
    private String mTitle;

    @NonNull
    @ColumnInfo(name="creator")
    private String mCreator;

    // CONSTRUCTOR
    public Pattern(@NonNull int imageResource, String title, String creator) {
        mImageResource = imageResource;
        mTitle = title;
        mCreator = creator;
        mUpdateTime = System.currentTimeMillis();
    }

    //GETTERS AND SETTERS
    public long getId() {
        return mId;
    }
    public void setId(long id) {
        this.mId = id;
    }

    public long getUpdateTime() { return  mUpdateTime; }
    public void setUpdateTime(long updateTime){ this.mUpdateTime = updateTime; }

    public int getImageResource() { return mImageResource; }
    public void setImageResource(int imageResource) { this.mImageResource = imageResource; }

    public String getTitle() { return mTitle; }
    public void setTitle(String title) { this.mTitle = title; }

    public String getCreator() { return mCreator; }
    public void setCreator(String creator) { this.mCreator = creator; }




    //parcelable implementation below
    //allows instances of this object to be passed through activities

    protected Pattern(Parcel in) {
        mImageResource = in.readInt();
        mTitle = in.readString();
        mCreator = in.readString();
    }

    public static final Parcelable.Creator<Pattern> CREATOR = new Parcelable.Creator<Pattern>() {
        @Override
        public Pattern createFromParcel(Parcel in) {
            return new Pattern(in);
        }

        @Override
        public Pattern[] newArray(int size) {
            return new Pattern[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(mImageResource);
        parcel.writeString(mTitle);
        parcel.writeString(mCreator);
    }
}


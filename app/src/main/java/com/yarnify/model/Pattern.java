package com.yarnify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.squareup.picasso.Picasso;

@Entity
public class Pattern implements Parcelable {

    //TABLE COLUMNS
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name="updated")
    private long mUpdateTime;

    @ColumnInfo(name="image")
    private String mImageResource;

    @NonNull
    @ColumnInfo(name="title")
    private String mTitle;

    @NonNull
    @ColumnInfo(name="creator")
    private String mCreator;

    @ColumnInfo(name="craft")
    private String mCraft;

    @ColumnInfo(name="patternURL")
    private String mURL;

    @ColumnInfo(name="totalYardage")
    private int mTotalYardage;

    //TODO

    //FK: yarn_weight

    //FK: pattern_needle_sizes

    // CONSTRUCTOR
    public Pattern(String imageResource, @NonNull String title, @NonNull String creator, String craft, String mURL, int totalYardage) {
        this.mImageResource = imageResource;
        this.mTitle = title;
        this.mCreator = creator;
        this.mCraft = craft;
        this.mURL = mURL;
        this.mTotalYardage = totalYardage;
        this.mUpdateTime = System.currentTimeMillis();
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

    public String getImageResource() { return mImageResource; }
    public void setImageResource(String imageResource) { this.mImageResource = imageResource; }

    public String getTitle() { return mTitle; }
    public void setTitle(String title) { this.mTitle = title; }

    public String getCreator() { return mCreator; }
    public void setCreator(String creator) { this.mCreator = creator; }

    public String getCraft() { return mCraft; }
    public void setCraft(String craft) { this.mCraft = craft; }

    public String getURL() { return mURL; }
    public void setURL(String URL) { this.mURL = URL; }

    public int getTotalYardage() { return mTotalYardage; }
    public void setTotalYardage(int totalYardage) { this.mTotalYardage = totalYardage; }



    //parcelable implementation below
    //allows instances of this object to be passed through activities

    protected Pattern(Parcel in) {
        mImageResource = in.readString();
        mTitle = in.readString();
        mCreator = in.readString();
        mCraft = in.readString();
        mURL = in.readString();
        mTotalYardage = in.readInt();
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
        parcel.writeString(mImageResource);
        parcel.writeString(mTitle);
        parcel.writeString(mCreator);
        parcel.writeString(mCraft);
        parcel.writeString(mURL);
        parcel.writeInt(mTotalYardage);
    }
}


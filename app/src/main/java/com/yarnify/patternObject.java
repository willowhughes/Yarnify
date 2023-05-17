package com.yarnify;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class patternObject implements Parcelable {

    //this class contains the data of each pattern gathered from the ravelry api

    private int mImageResource;
    private String mText1;
    private String mText2;


    public patternObject(int mImageResource, String mText1, String mText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }
    public int getImageResource() { return mImageResource; }

    public String getText1() { return mText1; }

    public String getText2() { return mText2; }

    //parcelable implementation below
    //allows instances of this object to be passed through activities

    protected patternObject(Parcel in) {
        mImageResource = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
    }

    public static final Creator<patternObject> CREATOR = new Creator<patternObject>() {
        @Override
        public patternObject createFromParcel(Parcel in) {
            return new patternObject(in);
        }

        @Override
        public patternObject[] newArray(int size) {
            return new patternObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(mImageResource);
        parcel.writeString(mText1);
        parcel.writeString(mText2);
    }
}

package com.yarnify.API.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponsePatternAttributes {

    @SerializedName("name")
    private String title;
    private String id;
    private String updated;
    private String image;
    private ResponseAttributeCraft craft;
    private ResponsePatternAuthor pattern_author;
    private ArrayList<ResponsePatternAttributesPhotos> photos;

    public String getTitle() {
        return title;
    }

    public ResponsePatternAuthor getPattern_author() {
        return pattern_author;
    }

    public ResponseAttributeCraft getCraft() {
        return craft;
    }
}

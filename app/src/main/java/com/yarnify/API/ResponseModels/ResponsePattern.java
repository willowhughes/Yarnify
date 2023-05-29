package com.yarnify.API.ResponseModels;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePattern {


    //need to dynamically get this field from query?
    @SerializedName("1335913")
    @Expose(deserialize = true)
    private JsonObject pattern;

    public JsonObject getPattern() {
        return pattern;
    }

    public void setPattern(JsonObject pattern) {
        this.pattern = pattern;
    }
}

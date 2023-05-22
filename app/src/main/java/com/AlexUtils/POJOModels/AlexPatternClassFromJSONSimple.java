package com.AlexUtils.POJOModels;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

import java.util.ArrayList;

//This is a simple class I'm trying to deserialize a JSON response into.
public class AlexPatternClassFromJSONSimple {

    @SerializedName("patterns")
    public JSONObject getPatterns() {
        return this.patterns;
    }

    public void setPatterns(JSONObject patterns) {
        this.patterns = patterns;
    }

    JSONObject patterns;

}

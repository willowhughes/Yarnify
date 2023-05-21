package com.AlexUtils;

import com.google.gson.annotations.SerializedName;

public class AlexModel {
    @SerializedName("pattern")
    private String pattern;


    public AlexModel(String pattern){
        this.pattern = pattern;
    }

    public String getPattern(){
        return pattern;
    }

    public void setPattern(String pattern){
        this.pattern = pattern;
    }
}

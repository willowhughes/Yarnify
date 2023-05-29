package com.yarnify.API.ResponseModels;

import com.google.gson.annotations.Expose;

public class ResponsePatternList {

    @Expose(deserialize = true)
    private ResponsePattern patterns;

    public ResponsePattern getPatterns() {
        return patterns;
    }

    public void setPatterns(ResponsePattern patterns) {
        this.patterns = patterns;
    }
}

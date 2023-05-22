package com.AlexUtils;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;


/*  Corresponds to this JSON.

           {
            "patternListClass": "This is a JSON with an array of JSON objects",
             "patternArray": [
                                {"firstJSONObjectKey": "firstJSONObjectValue"},
                                {"secondJSONObjectKey": "secondJSONObjectValue"}
                             ]
            }

    GSON will deserialize this JSON into this class.

*/
public class AlexModel {
    @SerializedName("patternListClass")
    private String patternListClass;

    @SerializedName("patternArray")
    private JSONArray[] patternArray;


    public AlexModel(String pattern){
        this.patternListClass = pattern;
    }

    public String getPatternListClass(){
        return patternListClass;
    }

    public void setPatternListClass(String pattern){
        this.patternListClass = pattern;
    }

    public JSONArray[] getPatternArray(){
        return patternArray;
    }

    public void setPatternArray(JSONArray[] patternArray){
        this.patternArray = patternArray;
    }
}

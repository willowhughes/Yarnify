package com.yarnify.API.ResponseModels.TypeAdapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.yarnify.API.ResponseModels.ResponsePatternAttributesPhotos;

import java.io.IOException;



//Unnecessary but good practice. This is the form that needs to happen for deserializing
// dynamic pattern ids


public class PhotosAdapter extends TypeAdapter<ResponsePatternAttributesPhotos> {
    @Override
    public void write(JsonWriter out, ResponsePatternAttributesPhotos value) throws IOException {

    }

    @Override
    public ResponsePatternAttributesPhotos read(JsonReader in) throws IOException {
        ResponsePatternAttributesPhotos photos = new ResponsePatternAttributesPhotos();
        in.beginObject();
        String fieldname = null;

        while (in.hasNext()) {

            JsonToken token = in.peek();

            if(token.equals(JsonToken.NAME)){
                fieldname = in.nextName();
            }

            if ("name".equals(fieldname)){
                token = in.peek();

            }
        }
        return null;
    }
}

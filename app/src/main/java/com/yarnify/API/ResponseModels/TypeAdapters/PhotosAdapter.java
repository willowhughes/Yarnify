package com.yarnify.API.ResponseModels.TypeAdapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.yarnify.API.ResponseModels.ResponsePatternAttributesPhoto;

import java.io.IOException;



//Unnecessary but good practice. This is the form that needs to happen for deserializing
// dynamic pattern ids


public class PhotosAdapter extends TypeAdapter<ResponsePatternAttributesPhoto> {
    @Override
    public void write(JsonWriter out, ResponsePatternAttributesPhoto value) throws IOException {

    }

    @Override
    public ResponsePatternAttributesPhoto read(JsonReader in) throws IOException {
        ResponsePatternAttributesPhoto photos = new ResponsePatternAttributesPhoto();
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

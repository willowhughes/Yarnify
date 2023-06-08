package com.yarnify.API.ResponseUtilities;

import com.yarnify.API.Request;
import com.yarnify.model.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public final class RequestToPattern {

    public RequestToPattern() {
        // Private constructor to prevent instantiation
    }

    public ArrayList<Pattern> parsePatternsFromJson(String url) throws JSONException {

        Request request = new Request(url);
        String jsonString = request.getResponse();
        ArrayList<Pattern> patterns = new ArrayList<>();

        JSONObject response = new JSONObject(jsonString);
        JSONArray patternArray = response.getJSONArray("patterns");

        for (int i = 0; i < patternArray.length(); i++) {
            JSONObject patternObject = patternArray.getJSONObject(i);

            // Extract pattern data from the JSON object
            long id = patternObject.getLong("id");
            String image = patternObject.getJSONObject("first_photo").getString("medium_url");
            String title = patternObject.getString("name");
            String creator = patternObject.getJSONObject("designer").getString("name");
            String craft = "knitting";  // Assuming a default value
            String patternURL = "https://www.ravelry.com/patterns/library/" + patternObject.getString("permalink");
            int minYardage = 0;  // Assuming a default value
            int maxYardage = 0;  // Assuming a default value

            // Create a new Pattern object with the extracted data
            Pattern pattern = new Pattern(image, title, creator, craft, patternURL, minYardage, maxYardage);
            patterns.add(pattern);
        }

        return patterns;
    }
}

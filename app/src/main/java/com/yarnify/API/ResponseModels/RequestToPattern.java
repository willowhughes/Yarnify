package com.yarnify.API.ResponseModels;

import com.yarnify.API.Request;
import com.yarnify.API.ResponseUtilities.ToPojo;
import com.yarnify.model.Pattern;

public final class RequestToPattern {

    private RequestToPattern() {
        // Private constructor to prevent instantiation
    }

    public static Pattern toPatternByUrl(String url) {
        Request request = new Request(url);
        ToPojo toPojo = new ToPojo();
        ResponsePatternList ac = toPojo.fromJSONSimple(request.getResponse());

        // I can make cleaner methods for these, but this is an example of how the classes
        // are deserialize and accessed
        String title1 = ac.getPatterns().getPatternAttributes().getTitle();
        String name1 = ac.getPatterns().getPatternAttributes().getPattern_author().getName();
        String craft1 = ac.getPatterns().getPatternAttributes().getCraft().getName();
        String photoURL1 = ac.getPatterns().getPatternAttributes().getPhotos().get(0).getMedium_url();
        String permalink1 = ac.getPatterns().getPatternAttributes().getPermalink();

        return new Pattern(photoURL1, title1, name1, craft1, permalink1, 0);
    }
}

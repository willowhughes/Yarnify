package com.AlexUtils.POJOModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


//Not sure GSON will deserialize into this beast or not
//Used the response from a Postman query to https://api.ravelry.com/patterns.json?ids=1335913
// and converted it to this class using https://json2csharp.com/code-converters/json-to-pojo
// Switched to testing with a more simple class called AlexPatternFromJSONSimple
public class AlexPatternClassFromJSON {

    @SerializedName("patterns")
    public ArrayList<Pattern> getPatterns() {
        return this.patterns;
    }

    public void setPatterns(ArrayList<Pattern> patterns) {
        this.patterns = patterns;
    }

    ArrayList<Pattern> patterns;

    public AlexPatternClassFromJSON() {

    }


    public class Pattern {
        @SerializedName("free")
        public boolean getFree() {
            return this.free;
        }

        public void setFree(boolean free) {
            this.free = free;
        }

        boolean free;

        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @SerializedName("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @SerializedName("permalink")
        public String getPermalink() {
            return this.permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        String permalink;

        @SerializedName("personal_attributes")
        public Object getPersonal_attributes() {
            return this.personal_attributes;
        }

        public void setPersonal_attributes(Object personal_attributes) {
            this.personal_attributes = personal_attributes;
        }

        Object personal_attributes;

        @SerializedName("first_photo")
        public FirstPhoto getFirst_photo() {
            return this.first_photo;
        }

        public void setFirst_photo(FirstPhoto first_photo) {
            this.first_photo = first_photo;
        }

        FirstPhoto first_photo;

        @SerializedName("designer")
        public Designer getDesigner() {
            return this.designer;
        }

        public void setDesigner(Designer designer) {
            this.designer = designer;
        }

        Designer designer;

        @SerializedName("pattern_author")
        public PatternAuthor getPattern_author() {
            return this.pattern_author;
        }

        public void setPattern_author(PatternAuthor pattern_author) {
            this.pattern_author = pattern_author;
        }

        PatternAuthor pattern_author;

        @SerializedName("pattern_sources")
        public ArrayList<PatternSource> getPattern_sources() {
            return this.pattern_sources;
        }

        public void setPattern_sources(ArrayList<PatternSource> pattern_sources) {
            this.pattern_sources = pattern_sources;
        }

        ArrayList<PatternSource> pattern_sources;
    }
    public class Designer {
        @SerializedName("crochet_pattern_count")
        public int getCrochet_pattern_count() {
            return this.crochet_pattern_count;
        }

        public void setCrochet_pattern_count(int crochet_pattern_count) {
            this.crochet_pattern_count = crochet_pattern_count;
        }

        int crochet_pattern_count;

        @SerializedName("favorites_count")
        public int getFavorites_count() {
            return this.favorites_count;
        }

        public void setFavorites_count(int favorites_count) {
            this.favorites_count = favorites_count;
        }

        int favorites_count;

        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @SerializedName("knitting_pattern_count")
        public int getKnitting_pattern_count() {
            return this.knitting_pattern_count;
        }

        public void setKnitting_pattern_count(int knitting_pattern_count) {
            this.knitting_pattern_count = knitting_pattern_count;
        }

        int knitting_pattern_count;

        @SerializedName("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @SerializedName("patterns_count")
        public int getPatterns_count() {
            return this.patterns_count;
        }

        public void setPatterns_count(int patterns_count) {
            this.patterns_count = patterns_count;
        }

        int patterns_count;

        @SerializedName("permalink")
        public String getPermalink() {
            return this.permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        String permalink;

        @SerializedName("users")
        public ArrayList<User> getUsers() {
            return this.users;
        }

        public void setUsers(ArrayList<User> users) {
            this.users = users;
        }

        ArrayList<User> users;
    }

    public class FirstPhoto {
        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @SerializedName("sort_order")
        public int getSort_order() {
            return this.sort_order;
        }

        public void setSort_order(int sort_order) {
            this.sort_order = sort_order;
        }

        int sort_order;

        @SerializedName("user_id")
        public int getUser_id() {
            return this.user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        int user_id;

        @SerializedName("x_offset")
        public int getX_offset() {
            return this.x_offset;
        }

        public void setX_offset(int x_offset) {
            this.x_offset = x_offset;
        }

        int x_offset;

        @SerializedName("y_offset")
        public int getY_offset() {
            return this.y_offset;
        }

        public void setY_offset(int y_offset) {
            this.y_offset = y_offset;
        }

        int y_offset;

        @SerializedName("square_url")
        public String getSquare_url() {
            return this.square_url;
        }

        public void setSquare_url(String square_url) {
            this.square_url = square_url;
        }

        String square_url;

        @SerializedName("medium_url")
        public String getMedium_url() {
            return this.medium_url;
        }

        public void setMedium_url(String medium_url) {
            this.medium_url = medium_url;
        }

        String medium_url;

        @SerializedName("thumbnail_url")
        public String getThumbnail_url() {
            return this.thumbnail_url;
        }

        public void setThumbnail_url(String thumbnail_url) {
            this.thumbnail_url = thumbnail_url;
        }

        String thumbnail_url;

        @SerializedName("small_url")
        public String getSmall_url() {
            return this.small_url;
        }

        public void setSmall_url(String small_url) {
            this.small_url = small_url;
        }

        String small_url;

        @SerializedName("medium2_url")
        public String getMedium2_url() {
            return this.medium2_url;
        }

        public void setMedium2_url(String medium2_url) {
            this.medium2_url = medium2_url;
        }

        String medium2_url;

        @SerializedName("small2_url")
        public String getSmall2_url() {
            return this.small2_url;
        }

        public void setSmall2_url(String small2_url) {
            this.small2_url = small2_url;
        }

        String small2_url;

        @SerializedName("caption")
        public Object getCaption() {
            return this.caption;
        }

        public void setCaption(Object caption) {
            this.caption = caption;
        }

        Object caption;

        @SerializedName("caption_html")
        public Object getCaption_html() {
            return this.caption_html;
        }

        public void setCaption_html(Object caption_html) {
            this.caption_html = caption_html;
        }

        Object caption_html;

        @SerializedName("copyright_holder")
        public Object getCopyright_holder() {
            return this.copyright_holder;
        }

        public void setCopyright_holder(Object copyright_holder) {
            this.copyright_holder = copyright_holder;
        }

        Object copyright_holder;
    }



    public class PatternAuthor {
        @SerializedName("crochet_pattern_count")
        public int getCrochet_pattern_count() {
            return this.crochet_pattern_count;
        }

        public void setCrochet_pattern_count(int crochet_pattern_count) {
            this.crochet_pattern_count = crochet_pattern_count;
        }

        int crochet_pattern_count;

        @SerializedName("favorites_count")
        public int getFavorites_count() {
            return this.favorites_count;
        }

        public void setFavorites_count(int favorites_count) {
            this.favorites_count = favorites_count;
        }

        int favorites_count;

        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @SerializedName("knitting_pattern_count")
        public int getKnitting_pattern_count() {
            return this.knitting_pattern_count;
        }

        public void setKnitting_pattern_count(int knitting_pattern_count) {
            this.knitting_pattern_count = knitting_pattern_count;
        }

        int knitting_pattern_count;

        @SerializedName("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @SerializedName("patterns_count")
        public int getPatterns_count() {
            return this.patterns_count;
        }

        public void setPatterns_count(int patterns_count) {
            this.patterns_count = patterns_count;
        }

        int patterns_count;

        @SerializedName("permalink")
        public String getPermalink() {
            return this.permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        String permalink;

        @SerializedName("users")
        public ArrayList<User> getUsers() {
            return this.users;
        }

        public void setUsers(ArrayList<User> users) {
            this.users = users;
        }

        ArrayList<User> users;
    }

    public class PatternSource {
        @SerializedName("amazon_rating")
        public Object getAmazon_rating() {
            return this.amazon_rating;
        }

        public void setAmazon_rating(Object amazon_rating) {
            this.amazon_rating = amazon_rating;
        }

        Object amazon_rating;

        @SerializedName("amazon_reviews")
        public Object getAmazon_reviews() {
            return this.amazon_reviews;
        }

        public void setAmazon_reviews(Object amazon_reviews) {
            this.amazon_reviews = amazon_reviews;
        }

        Object amazon_reviews;

        @SerializedName("amazon_sales_rank")
        public Object getAmazon_sales_rank() {
            return this.amazon_sales_rank;
        }

        public void setAmazon_sales_rank(Object amazon_sales_rank) {
            this.amazon_sales_rank = amazon_sales_rank;
        }

        Object amazon_sales_rank;

        @SerializedName("amazon_updated_at")
        public Object getAmazon_updated_at() {
            return this.amazon_updated_at;
        }

        public void setAmazon_updated_at(Object amazon_updated_at) {
            this.amazon_updated_at = amazon_updated_at;
        }

        Object amazon_updated_at;

        @SerializedName("amazon_url")
        public Object getAmazon_url() {
            return this.amazon_url;
        }

        public void setAmazon_url(Object amazon_url) {
            this.amazon_url = amazon_url;
        }

        Object amazon_url;

        @SerializedName("approved_patterns_count")
        public int getApproved_patterns_count() {
            return this.approved_patterns_count;
        }

        public void setApproved_patterns_count(int approved_patterns_count) {
            this.approved_patterns_count = approved_patterns_count;
        }

        int approved_patterns_count;

        @SerializedName("asin")
        public String getAsin() {
            return this.asin;
        }

        public void setAsin(String asin) {
            this.asin = asin;
        }

        String asin;

        @SerializedName("author")
        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        String author;

        @SerializedName("author_pattern_author_id")
        public Object getAuthor_pattern_author_id() {
            return this.author_pattern_author_id;
        }

        public void setAuthor_pattern_author_id(Object author_pattern_author_id) {
            this.author_pattern_author_id = author_pattern_author_id;
        }

        Object author_pattern_author_id;

        @SerializedName("author_surname")
        public String getAuthor_surname() {
            return this.author_surname;
        }

        public void setAuthor_surname(String author_surname) {
            this.author_surname = author_surname;
        }

        String author_surname;

        @SerializedName("book_binding")
        public Object getBook_binding() {
            return this.book_binding;
        }

        public void setBook_binding(Object book_binding) {
            this.book_binding = book_binding;
        }

        Object book_binding;

        @SerializedName("completed")
        public boolean getCompleted() {
            return this.completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        boolean completed;

        @SerializedName("created_at")
        public String getCreated_at() {
            return this.created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        String created_at;

        @SerializedName("created_by_user_id")
        public int getCreated_by_user_id() {
            return this.created_by_user_id;
        }

        public void setCreated_by_user_id(int created_by_user_id) {
            this.created_by_user_id = created_by_user_id;
        }

        int created_by_user_id;

        @SerializedName("designer_pending_patterns_count")
        public int getDesigner_pending_patterns_count() {
            return this.designer_pending_patterns_count;
        }

        public void setDesigner_pending_patterns_count(int designer_pending_patterns_count) {
            this.designer_pending_patterns_count = designer_pending_patterns_count;
        }

        int designer_pending_patterns_count;

        @SerializedName("designer_users_count")
        public int getDesigner_users_count() {
            return this.designer_users_count;
        }

        public void setDesigner_users_count(int designer_users_count) {
            this.designer_users_count = designer_users_count;
        }

        int designer_users_count;

        @SerializedName("editorships_count")
        public int getEditorships_count() {
            return this.editorships_count;
        }

        public void setEditorships_count(int editorships_count) {
            this.editorships_count = editorships_count;
        }

        int editorships_count;

        @SerializedName("favorites_count")
        public int getFavorites_count() {
            return this.favorites_count;
        }

        public void setFavorites_count(int favorites_count) {
            this.favorites_count = favorites_count;
        }

        int favorites_count;

        @SerializedName("first_photo_id")
        public Object getFirst_photo_id() {
            return this.first_photo_id;
        }

        public void setFirst_photo_id(Object first_photo_id) {
            this.first_photo_id = first_photo_id;
        }

        Object first_photo_id;

        @SerializedName("flaggings_count")
        public int getFlaggings_count() {
            return this.flaggings_count;
        }

        public void setFlaggings_count(int flaggings_count) {
            this.flaggings_count = flaggings_count;
        }

        int flaggings_count;

        @SerializedName("fulfilled_by_ravelry")
        public boolean getFulfilled_by_ravelry() {
            return this.fulfilled_by_ravelry;
        }

        public void setFulfilled_by_ravelry(boolean fulfilled_by_ravelry) {
            this.fulfilled_by_ravelry = fulfilled_by_ravelry;
        }

        boolean fulfilled_by_ravelry;

        @SerializedName("has_photo")
        public boolean getHas_photo() {
            return this.has_photo;
        }

        public void setHas_photo(boolean has_photo) {
            this.has_photo = has_photo;
        }

        boolean has_photo;

        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @SerializedName("isbn_13")
        public Object getIsbn_13() {
            return this.isbn_13;
        }

        public void setIsbn_13(Object isbn_13) {
            this.isbn_13 = isbn_13;
        }

        Object isbn_13;

        @SerializedName("issue")
        public Object getIssue() {
            return this.issue;
        }

        public void setIssue(Object issue) {
            this.issue = issue;
        }

        Object issue;

        @SerializedName("keywords")
        public String getKeywords() {
            return this.keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        String keywords;

        @SerializedName("label")
        public Object getLabel() {
            return this.label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        Object label;

        @SerializedName("large_image_url")
        public Object getLarge_image_url() {
            return this.large_image_url;
        }

        public void setLarge_image_url(Object large_image_url) {
            this.large_image_url = large_image_url;
        }

        Object large_image_url;

        @SerializedName("last_pattern_edit")
        public String getLast_pattern_edit() {
            return this.last_pattern_edit;
        }

        public void setLast_pattern_edit(String last_pattern_edit) {
            this.last_pattern_edit = last_pattern_edit;
        }

        String last_pattern_edit;

        @SerializedName("link_id")
        public Object getLink_id() {
            return this.link_id;
        }

        public void setLink_id(Object link_id) {
            this.link_id = link_id;
        }

        Object link_id;

        @SerializedName("list_price")
        public Object getList_price() {
            return this.list_price;
        }

        public void setList_price(Object list_price) {
            this.list_price = list_price;
        }

        Object list_price;

        @SerializedName("lock_version")
        public int getLock_version() {
            return this.lock_version;
        }

        public void setLock_version(int lock_version) {
            this.lock_version = lock_version;
        }

        int lock_version;

        @SerializedName("medium_image_url")
        public Object getMedium_image_url() {
            return this.medium_image_url;
        }

        public void setMedium_image_url(Object medium_image_url) {
            this.medium_image_url = medium_image_url;
        }

        Object medium_image_url;

        @SerializedName("name")
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name;

        @SerializedName("out_of_print")
        public boolean getOut_of_print() {
            return this.out_of_print;
        }

        public void setOut_of_print(boolean out_of_print) {
            this.out_of_print = out_of_print;
        }

        boolean out_of_print;

        @SerializedName("pattern_source_type_id")
        public int getPattern_source_type_id() {
            return this.pattern_source_type_id;
        }

        public void setPattern_source_type_id(int pattern_source_type_id) {
            this.pattern_source_type_id = pattern_source_type_id;
        }

        int pattern_source_type_id;

        @SerializedName("patterns_count")
        public int getPatterns_count() {
            return this.patterns_count;
        }

        public void setPatterns_count(int patterns_count) {
            this.patterns_count = patterns_count;
        }

        int patterns_count;

        @SerializedName("pending_patterns_count")
        public int getPending_patterns_count() {
            return this.pending_patterns_count;
        }

        public void setPending_patterns_count(int pending_patterns_count) {
            this.pending_patterns_count = pending_patterns_count;
        }

        int pending_patterns_count;

        @SerializedName("periodical")
        public boolean getPeriodical() {
            return this.periodical;
        }

        public void setPeriodical(boolean periodical) {
            this.periodical = periodical;
        }

        boolean periodical;

        @SerializedName("permalink")
        public String getPermalink() {
            return this.permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        String permalink;

        @SerializedName("photos_permitted")
        public boolean getPhotos_permitted() {
            return this.photos_permitted;
        }

        public void setPhotos_permitted(boolean photos_permitted) {
            this.photos_permitted = photos_permitted;
        }

        boolean photos_permitted;

        @SerializedName("popularity")
        public double getPopularity() {
            return this.popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        double popularity;

        @SerializedName("popularity_rank")
        public Object getPopularity_rank() {
            return this.popularity_rank;
        }

        public void setPopularity_rank(Object popularity_rank) {
            this.popularity_rank = popularity_rank;
        }

        Object popularity_rank;

        @SerializedName("price")
        public Object getPrice() {
            return this.price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        Object price;

        @SerializedName("publication_date")
        public String getPublication_date() {
            return this.publication_date;
        }

        public void setPublication_date(String publication_date) {
            this.publication_date = publication_date;
        }

        String publication_date;

        @SerializedName("publication_date_set")
        public int getPublication_date_set() {
            return this.publication_date_set;
        }

        public void setPublication_date_set(int publication_date_set) {
            this.publication_date_set = publication_date_set;
        }

        int publication_date_set;

        @SerializedName("publication_day_set")
        public int getPublication_day_set() {
            return this.publication_day_set;
        }

        public void setPublication_day_set(int publication_day_set) {
            this.publication_day_set = publication_day_set;
        }

        int publication_day_set;

        @SerializedName("publication_sort_order")
        public int getPublication_sort_order() {
            return this.publication_sort_order;
        }

        public void setPublication_sort_order(int publication_sort_order) {
            this.publication_sort_order = publication_sort_order;
        }

        int publication_sort_order;

        @SerializedName("publication_year")
        public int getPublication_year() {
            return this.publication_year;
        }

        public void setPublication_year(int publication_year) {
            this.publication_year = publication_year;
        }

        int publication_year;

        @SerializedName("publisher_id")
        public Object getPublisher_id() {
            return this.publisher_id;
        }

        public void setPublisher_id(Object publisher_id) {
            this.publisher_id = publisher_id;
        }

        Object publisher_id;

        @SerializedName("shelf_image_path")
        public Object getShelf_image_path() {
            return this.shelf_image_path;
        }

        public void setShelf_image_path(Object shelf_image_path) {
            this.shelf_image_path = shelf_image_path;
        }

        Object shelf_image_path;

        @SerializedName("shelf_image_size")
        public Object getShelf_image_size() {
            return this.shelf_image_size;
        }

        public void setShelf_image_size(Object shelf_image_size) {
            this.shelf_image_size = shelf_image_size;
        }

        Object shelf_image_size;

        @SerializedName("small_image_url")
        public Object getSmall_image_url() {
            return this.small_image_url;
        }

        public void setSmall_image_url(Object small_image_url) {
            this.small_image_url = small_image_url;
        }

        Object small_image_url;

        @SerializedName("source_group_id")
        public Object getSource_group_id() {
            return this.source_group_id;
        }

        public void setSource_group_id(Object source_group_id) {
            this.source_group_id = source_group_id;
        }

        Object source_group_id;

        @SerializedName("stickies_count")
        public int getStickies_count() {
            return this.stickies_count;
        }

        public void setStickies_count(int stickies_count) {
            this.stickies_count = stickies_count;
        }

        int stickies_count;

        @SerializedName("store_id")
        public int getStore_id() {
            return this.store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        int store_id;

        @SerializedName("updated_at")
        public String getUpdated_at() {
            return this.updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        String updated_at;

        @SerializedName("url")
        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        String url;

        @SerializedName("work_id")
        public Object getWork_id() {
            return this.work_id;
        }

        public void setWork_id(Object work_id) {
            this.work_id = work_id;
        }

        Object work_id;

        @SerializedName("notes")
        public String getNotes() {
            return this.notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        String notes;
    }

    public class User {
        @SerializedName("id")
        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        int id;

        @SerializedName("username")
        public String getUsername() {
            return this.username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        String username;

        @SerializedName("tiny_photo_url")
        public String getTiny_photo_url() {
            return this.tiny_photo_url;
        }

        public void setTiny_photo_url(String tiny_photo_url) {
            this.tiny_photo_url = tiny_photo_url;
        }

        String tiny_photo_url;

        @SerializedName("small_photo_url")
        public String getSmall_photo_url() {
            return this.small_photo_url;
        }

        public void setSmall_photo_url(String small_photo_url) {
            this.small_photo_url = small_photo_url;
        }

        String small_photo_url;

        @SerializedName("photo_url")
        public String getPhoto_url() {
            return this.photo_url;
        }

        public void setPhoto_url(String photo_url) {
            this.photo_url = photo_url;
        }

        String photo_url;
    }

}

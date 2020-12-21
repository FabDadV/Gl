package com.example.g.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    public String id;
    public String owner;
    public String secret;
    public String server;
    public Integer farm;
    public String title;
    public Integer ispublic;
    public Integer isfriend;
    public Integer isfamily;
    public String url_n;
    public String heightS;
    public String widthS;

    public String getUrlS() {
        return url_n;
    }
}
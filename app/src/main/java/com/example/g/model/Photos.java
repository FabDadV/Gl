package com.example.g.model;

import java.util.List;

public class Photos {

    public Integer page;
    public String pages;
    public Integer perpage;
    public String total;
    public List<Photo> photo = null;

    public List<Photo> getPhoto() {
        return photo;
    }

}


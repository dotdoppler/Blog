package com.doppler.blog.models;

/**
 * Created by doppler on 2016/5/23.
 */
public class Hashtag extends BaseModel {


    private static final long serialVersionUID = 704937242013239319L;
    private  String  name;
    public Hashtag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

package com.doppler.blog.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by doppler on 2016/5/23.
 */
@Document(collection = "hashtag")

public class Hashtag extends BaseModel {


    private static final long serialVersionUID = 704937242013239319L;
    @Field(value = "name")
    private  String  name;
    public Hashtag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

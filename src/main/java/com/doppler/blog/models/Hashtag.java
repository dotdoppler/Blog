package com.doppler.blog.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by doppler on 2016/5/23.
 */
@Document(collection = "hashtag")

public class Hashtag extends BaseModel {

    @Field(value = "name")
    private  String  name;

    public Hashtag(){};
    public Hashtag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

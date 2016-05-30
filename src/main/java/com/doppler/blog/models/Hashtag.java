package com.doppler.blog.models;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by doppler on 2016/5/23.
 */
@Document(collection = "hashtag")

public class Hashtag extends BaseModel {

    @Indexed(name = "name",unique = true,sparse = true)
    @Field(value = "name")
    private String name;

    public Hashtag(){};
    public Hashtag(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

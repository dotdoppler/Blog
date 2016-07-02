package com.doppler.blog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * Created by doppler on 2016/5/28.
 */
public abstract class BaseModel implements Serializable {


    @Id
    protected String id;
    @Field(value = "createdAt")
    protected String createdAt;
    @Field(value = "updatedAt")
    protected String updatedAt;

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}

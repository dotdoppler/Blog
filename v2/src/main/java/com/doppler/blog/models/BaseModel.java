package com.doppler.blog.models;

import java.io.Serializable;

/**
 * Created by doppler on 2016/5/28.
 */
public abstract class BaseModel implements Serializable {

    protected Long id;
    protected String createdAt;
    protected String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

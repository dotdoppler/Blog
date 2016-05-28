package com.doppler.blog.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * capped collection with only one document
 * db.createCollection("setting",{"capped" : true, "size" : 512, "max" : 1})

 * Created by doppler on 2016/5/28.
 */
@Document(collection = "setting")
public class Setting {
    @Id
    private  String id;

    @NotNull
    @Field(value = "siteName")
    private String siteName;

    @NotNull
    @Field(value = "slogan")
    private String slogan;

    @Field(value = "notification")
    private String notification;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}

package com.doppler.blog.models;

import javax.validation.constraints.NotNull;



public class Setting extends BaseModel {

    private static final long serialVersionUID = 9127040950888014691L;
    @NotNull
    private String siteName;

    @NotNull
    private String slogan;

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

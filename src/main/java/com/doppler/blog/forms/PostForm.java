package com.doppler.blog.forms;

import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class PostForm {
    @NotNull
    private String title;
    @NotNull
    private String content;

    private PostFormat postFormat;

    private PostStatus postStatus;

    private String permalink;

    private String postTags;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostFormat getPostFormat() {
        return postFormat;
    }

    public void setPostFormat(PostFormat postFormat) {
        this.postFormat = postFormat;
    }

    public PostStatus getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPostTags() {
        return postTags;
    }

    public void setPostTags(String postTags) {
        this.postTags = postTags;
    }
}

package com.doppler.blog.models;

import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.StringUtils;

import java.util.Set;

/**
 * Created by doppler on 2016/5/23.
 */
@Document(collection = "post")
public class Post extends BaseModel {


    private static final long serialVersionUID = -8032144622123598690L;
    private User user;

    @Field(value = "title")
    private String title;

    @Field(value = "content")
    private String content;

    @Field(value = "link")
    private String link;

    private String renderedContent;

    private PostStatus postStatus = PostStatus.PUBLISHED;

    private PostFormat postFormat = PostFormat.MARKDOWN;

    //private PostType postType = PostType.POST;

    @Field(value = "hashtags")
    private Set<String> hashtags;


    public String getRenderedContent() {
        if (this.postFormat == PostFormat.MARKDOWN)
            return renderedContent;

        return getContent();
    }

    @Override
    public String toString() {
        return this.title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setRenderedContent(String renderedContent) {
        this.renderedContent = renderedContent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Set<String> hashtags) {
        this.hashtags = hashtags;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        String token = link.toLowerCase().replace("\n", " ").replaceAll("[^a-z\\d\\s]", " ");
        this.link = StringUtils.arrayToDelimitedString(StringUtils.tokenizeToStringArray(token, " "), "-");
    }
}

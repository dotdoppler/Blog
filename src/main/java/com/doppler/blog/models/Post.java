package com.doppler.blog.models;

import com.doppler.blog.models.support.PostFormat;
import com.doppler.blog.models.support.PostStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by doppler on 2016/5/23.
 */
@Document(collection = "post")
public class Post  {

    @Id
    private String id;
    private User user;

    @Field(value = "title")
    private String title;

    private String content;

    @Field(value = "link")
    private String link;

    private String renderedContent;

    private PostStatus postStatus = PostStatus.PUBLISHED;

    private PostFormat postFormat = PostFormat.MARKDOWN;

    //private PostType postType = PostType.POST;


    private Set<Tag> tags = new HashSet<Tag>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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


//    public PostType getPostType() {
//        return postType;
//    }
//
//    public void setPostType(PostType postType) {
//        this.postType = postType;
//    }

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

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        String token = link.toLowerCase().replace("\n", " ").replaceAll("[^a-z\\d\\s]", " ");
        this.link = StringUtils.arrayToDelimitedString(StringUtils.tokenizeToStringArray(token, " "), "-");
    }
}

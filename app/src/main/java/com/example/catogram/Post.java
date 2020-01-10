package com.example.catogram;

import android.content.Context;
import android.content.Intent;

public class Post {
    private String id;
    private String userName;
    private String profileImgUrl;
    private String mainImgUrl;
    private String desc;
    private String numLikes;
    private String datePosted;

    static final String IMAGE_KEY = "Image Resource";
    static final String POST_KEY = "Post";


    public Post (String id, String userName, String profileImgUrl, String mainImgUrl, String desc, String numLikes, String datePosted){
        this.id=id;
        this.userName = userName;
        this.profileImgUrl = profileImgUrl;
        this.mainImgUrl = mainImgUrl;
        this.desc = desc;
        this.numLikes = numLikes;
        this.datePosted = datePosted;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(String numLikes) {
        this.numLikes = numLikes;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }



}

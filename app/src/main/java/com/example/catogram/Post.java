package com.example.catogram;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class Post {
    private String userName;
    private String profileImgUrl;
    private int mainImgUrl;
    private String desc;
    private Integer numLikes;
    private Integer datePosted;

    static final String IMAGE_KEY = "Image Resource";

    public Post (String userName,String profileImgUrl,Integer mainImgUrl,String desc,Integer numLikes,Integer datePosted){

        this.userName = userName;
        this.profileImgUrl = profileImgUrl;
        this.mainImgUrl = mainImgUrl;
        this.desc = desc;
        this.numLikes = numLikes;
        this.datePosted = datePosted;

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

    public int getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(Integer mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(Integer numLikes) {
        this.numLikes = numLikes;
    }

    public Integer getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Integer datePosted) {
        this.datePosted = datePosted;
    }

    static Intent starter(Context context, @DrawableRes int imageResId) {
        Intent commentIntent = new Intent(context, Comments.class);

        commentIntent.putExtra(IMAGE_KEY, imageResId);
        return commentIntent;
    }

}

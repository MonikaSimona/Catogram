package com.example.catogram;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.DrawableRes;

public class Post {
    private String userName;
    private int profileImgUrl;
    private int mainImgUrl;
    private String desc;
    private String numLikes;
    private String datePosted;

    static final String IMAGE_KEY = "Image Resource";

    public Post (String userName, int profileImgUrl, int mainImgUrl, String desc, String numLikes, String datePosted){

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

    public int getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(int profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public int getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(int mainImgUrl) {
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

    static Intent starter(Context context, @DrawableRes int imageResId) {
        Intent commentIntent = new Intent(context, Comments.class);

        commentIntent.putExtra(IMAGE_KEY, imageResId);
        return commentIntent;
    }

}

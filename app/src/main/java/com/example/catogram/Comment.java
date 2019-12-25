package com.example.catogram;

import com.google.gson.annotations.SerializedName;

class Comment {
    @SerializedName("id")
    private String id;

    @SerializedName("postId")
    private String postId;

    @SerializedName("createdAt")
    private String datePosted;

    @SerializedName("userName")
    private String comUserName;

    @SerializedName("userAvatar")
    private String comProfileImg;

    @SerializedName("comment")
    private String comment;


    public Comment(String comProfileImg, String comUserName, String comment ,String datePosted) {
        this.comProfileImg = comProfileImg;
        this.comUserName = comUserName;
        this.comment = comment;
        this.datePosted= datePosted;
    }

    public String getComProfileImg() {
        return comProfileImg;
    }

    public String getComUserName() {
        return comUserName;
    }

    public String getComment() {
        return comment;
    }

    public String getId() {
        return id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public void setComProfileImg(String comProfileImg) {
        this.comProfileImg = comProfileImg;
    }

    public void setComUserName(String comUserName) {
        this.comUserName = comUserName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(String id) {
        this.id = id;
    }
}

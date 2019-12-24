package com.example.catogram;

public class Comment {

    private String comProfileImg;
    private String comUserName;
    private String comment;

    public Comment(String comProfileImg, String comUserName, String comment) {
        this.comProfileImg = comProfileImg;
        this.comUserName = comUserName;
        this.comment = comment;
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

    public void setComProfileImg(String comProfileImg) {
        this.comProfileImg = comProfileImg;
    }

    public void setComUserName(String comUserName) {
        this.comUserName = comUserName;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

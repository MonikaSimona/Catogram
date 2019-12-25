package com.example.catogram;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("/posts")
    Call<List<Post>>  getPostsJson();
    Call<List<Comment>> getCommentsJson();
    @POST("/posts")
    Call<Post> createPost(@Body Post requestPosts);
    Call<Comment> createComment(@Body Comment requestComment);



}

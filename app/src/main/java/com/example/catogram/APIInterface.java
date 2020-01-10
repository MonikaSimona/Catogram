package com.example.catogram;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

interface APIInterface {

    @GET("/posts")
    Call<ArrayList<Post>>  getPostsJson();
    @GET ("posts/{id}/comments")
    Call<ArrayList<Comment>> getCommentsJson(@Path("id") String postId);
    @POST("/posts")
    Call<Post> createPost(@Body Post requestPosts);
    @POST("posts/{id}/comments")
    Call<Comment> createComment(@Path ("id") String id,@Body Comment requestComment);



}

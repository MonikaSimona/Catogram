package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Comments extends AppCompatActivity {

    private ArrayList<Comment> comments= new ArrayList<>();
    private CommentAdapter commentAdapter;
    private RecyclerView commentRecyclerView;

    private EditText newComment;
    public String postID;
    ImageButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        postID = getIntent().getStringExtra(Post.POST_KEY);

       commentRecyclerView = findViewById(R.id.recView);
       commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

       getCommentResponse();

    }



    private void getCommentResponse() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://5ddfd7adbb46ce001434bca8.mockapi.io/posts/{postId}/comments/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface APIinterface=retrofit.create(APIInterface.class);
        Call<ArrayList<Comment>> call = APIinterface.getCommentsJson(postID);
        call.enqueue(new Callback<ArrayList<Comment>>(){


            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                comments = response.body();
                commentAdapter = new CommentAdapter(comments, Comments.this);
                commentRecyclerView.setAdapter(commentAdapter);

                Toast.makeText(Comments.this,"SUCCESS",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                Toast.makeText(Comments.this,"FAILED",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void back(View view) {
        Intent backIntent = new Intent(this,MainActivity.class);
        startActivity(backIntent);

    }

    public void send(View view) {
        createCommentRequest();

    }
    private void createCommentRequest() {

        newComment=findViewById(R.id.newComment);

        Editable commentTextE= newComment.getText();
        String commentText= commentTextE.toString();
        Comment commentRequest = new Comment("","Bojana",commentText,"25/12/2019");

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://5ddfd7adbb46ce001434bca8.mockapi.io/posts/{postId}/comments/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface APIinterface=retrofit.create(APIInterface.class);
        Call<Comment> getComment = APIinterface.createComment(postID,commentRequest);

        getComment.enqueue(new Callback<Comment>() {
            @Override
            public void onResponse(Call<Comment> call, Response<Comment> response) {

                Comment commentResponse= response.body();

            }

            @Override
            public void onFailure(Call<Comment> call, Throwable t) {


            }
        });

    }
}

package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Comments extends AppCompatActivity {

    ArrayList<Comment> comments= new ArrayList<>();
    private CommentAdapter commentAdapter;
    private RecyclerView commentRecyclerView;

    EditText newComment;
    ImageButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

       commentRecyclerView=(RecyclerView)findViewById(R.id.recView);
       commentRecyclerView.setLayoutManager(new LinearLayoutManager(this));

       getCommentResponse();

    }



    private void getCommentResponse() {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://5ddfd7adbb46ce001434bca8.mockapi.io/posts/{postId}/comments/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface APIinterface=retrofit.create(APIInterface.class);
        Call<List<Comment>> call = APIinterface.getCommentJson();
        call.enqueue(new Callback<List<Comment>>(){


            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                comments = new ArrayList<>(Comments.this,comments);
                commentAdapter = new CommentAdapter(comments, Comments.this);
                commentRecyclerView.setAdapter(commentAdapter);

                Toast.makeText(Comments.this,"SUCCESS",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
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
        Call<Comment> getComment = APIinterface.createComment(commentRequest);

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

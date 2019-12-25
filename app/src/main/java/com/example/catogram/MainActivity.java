package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Post> posts ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        createPostRequest();


        getPostsResponse();


    }

    private void createPostRequest() {
        Post postRequest = new Post("Simona ","","","My new post","123","2/2/2012");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://5e0252d463d08b0014a2885b.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        Call<Post> getPosts = apiInterface.createPost(postRequest);
        getPosts.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Post postResponse = response.body();

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }

    private void getPostsResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://5e0252d463d08b0014a2885b.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        Call<List<Post>> call = apiInterface.getPostsJson();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                posts = new ArrayList<>(response.body());
                myAdapter = new PostAdapter(MainActivity.this,posts);
                recyclerView.setAdapter(myAdapter);
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_SHORT).show();


            }
        });

    }


}


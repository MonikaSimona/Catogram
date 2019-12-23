package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Post> posts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recView);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);

        posts = new ArrayList<Post>();

        myAdapter = new PostAdapter(posts,this);

        recyclerView.setAdapter(myAdapter);

        initializeData();



    }
private void initializeData(){
    String [] postList = getResources().getStringArray(R.array.userNames);
    String [] desc = getResources().getStringArray(R.array.desc);
    String [] datePosted = getResources().getStringArray(R.array.datePosted);
    String [] numLikes = getResources().getStringArray(R.array.numLikes);
    TypedArray profileImgRes = getResources().obtainTypedArray(R.array.profileImg);
    TypedArray mainImage = getResources().obtainTypedArray(R.array.mainImg);
    posts.clear();

    for (int i =0; i<postList.length;i++){
        posts.add(new Post(postList[i],profileImgRes.getResourceId(i,0),
                mainImage.getResourceId(i,0),desc[i],numLikes[i],datePosted[i]));
    }
    //Recycle the typed array
    profileImgRes.recycle();
    myAdapter.notifyDataSetChanged();
}
public void resetSports (View view){
        initializeData();
}

}

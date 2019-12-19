package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        posts.add(new Post("kiki","http://mybluerobot.com/wp-content/plugins/svg-avatars-generator/data/custom-img/girl.png","https://images.pexels.com/photos/461909/pexels-photo-461909.jpeg?cs=srgb&dl=beautiful-clouds-country-461909.jpg&fm=jpg","So breathtaking view",5,5/2/2012));
        posts.add(new Post("pepe","https://yt3.ggpht.com/-y61FXn8CVUc/AAAAAAAAAAI/AAAAAAAAAAA/T2Dyj28KuSA/s900-c-k-no/photo.jpg","http://i.ytimg.com/vi/26Aw5whMWeE/maxresdefault.jpg","Winter Wonderland",16,5/2/2012));
        posts.add(new Post("pufi","https://blog.eu.playstation.com/files/avatars/avatar_467916.jpg","https://img.chewy.com/is/image/catalog/49634_PT2._AC_SL1500_V1495492556_.jpg","Messy Eater #lunch",52,5/2/2012));
        posts.add(new Post("kiki","http://mybluerobot.com/wp-content/plugins/svg-avatars-generator/data/custom-img/girl.png","https://images.pexels.com/photos/461909/pexels-photo-461909.jpeg?cs=srgb&dl=beautiful-clouds-country-461909.jpg&fm=jpg","So breathtaking view",5,5/2/2012));
        posts.add(new Post("pepe","https://yt3.ggpht.com/-y61FXn8CVUc/AAAAAAAAAAI/AAAAAAAAAAA/T2Dyj28KuSA/s900-c-k-no/photo.jpg","http://i.ytimg.com/vi/26Aw5whMWeE/maxresdefault.jpg","Winter Wonderland",16,5/2/2012));
        posts.add(new Post("pufi","https://blog.eu.playstation.com/files/avatars/avatar_467916.jpg","https://img.chewy.com/is/image/catalog/49634_PT2._AC_SL1500_V1495492556_.jpg","Messy Eater #lunch",52,5/2/2012));

        myAdapter = new PostAdapter(posts,this);

        recyclerView.setAdapter(myAdapter);
    }

}

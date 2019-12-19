package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Comments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        ImageView commentImg = (ImageView)findViewById(R.id.mainImg);

        Drawable drawable= ContextCompat.getDrawable(this,getIntent().getIntExtra(Post.IMAGE_KEY,0));

        commentImg.setImageDrawable(drawable);
    }

}

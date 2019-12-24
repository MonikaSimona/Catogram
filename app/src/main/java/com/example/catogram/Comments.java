package com.example.catogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Comments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        ImageView commentImg = (ImageView)findViewById(R.id.mainImg);
        ImageButton backButton = findViewById(R.id.back);



        Drawable drawable= ContextCompat.getDrawable(this,getIntent().getIntExtra(Post.IMAGE_KEY,0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.blue(Color.BLUE));

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        Glide.with(this).load(getIntent().getIntExtra(Post.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(commentImg);
    }

    public void back(View view) {
        Intent backIntent = new Intent(this,MainActivity.class);
        startActivity(backIntent);

    }
}

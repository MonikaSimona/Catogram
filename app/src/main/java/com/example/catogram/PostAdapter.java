package com.example.catogram;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    public ArrayList<Post> posts;
    public Context mContext;
    private GradientDrawable mGradientDrawable;




     PostAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.mContext = context;


        Drawable drawable = ContextCompat.getDrawable
                (context,R.drawable.cat1);

        mGradientDrawable = new GradientDrawable();
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.layout_posts, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {


        Post currentPost = posts.get(i);
        viewHolder.bindTo(currentPost);


    }
    @Override
    public int getItemCount() {
        return posts.size();
    }



    static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

       private CircleImageView profileImg;
       private TextView userName;
       private ImageView mainImgUrl;
       private TextView desc;
       private TextView numLikes;
       private ImageButton iconLike;
       private TextView datePosted;
       private RelativeLayout rl;
       private GradientDrawable mGradientDrawable;
       public Post mCurrentPost;
       private Context mContext;

        ViewHolder(Context context,View itemView,GradientDrawable gradientDrawable) {
            super(itemView);

            profileImg = itemView.findViewById(R.id.profileImg);
            userName = itemView.findViewById(R.id.userName);
            mainImgUrl = itemView.findViewById(R.id.mainImg);
            desc = itemView.findViewById(R.id.desc);
            numLikes = itemView.findViewById(R.id.numLikes);
            iconLike = itemView.findViewById(R.id.icon);
            datePosted = itemView.findViewById(R.id.datePosted);
            rl = itemView.findViewById(R.id.rl);

            mContext = context;
            mGradientDrawable = gradientDrawable;


            itemView.setOnClickListener(this);


        }


        void bindTo(Post CurrentPost){

           userName.setText(CurrentPost.getUserName());
           desc.setText(CurrentPost.getDesc());
           numLikes.setText(CurrentPost.getNumLikes());
           datePosted.setText(CurrentPost.getDatePosted());


            mCurrentPost = CurrentPost;


            Glide.with(mContext).load(CurrentPost.
                    getProfileImgUrl()).placeholder(mGradientDrawable).into(profileImg);
            Glide.with(mContext).load(CurrentPost.
                    getMainImgUrl()).placeholder(mGradientDrawable).into(mainImgUrl);


        }

        @Override
        public void onClick(View view) {

            Intent commentIntent =  Post.starter(mContext, mCurrentPost.getMainImgUrl());

            mContext.startActivity(commentIntent);
        }

    }

}


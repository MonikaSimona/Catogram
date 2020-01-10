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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.catogram.Post.POST_KEY;
import static com.example.catogram.Post.IMAGE_KEY;



public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private ArrayList<Post> posts;
    private Context mContext;




     public PostAdapter(Context context,ArrayList<Post> posts) {
        this.posts = posts;
        this.mContext = context;

        }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_posts,viewGroup,false);
        return new PostAdapter.ViewHolder(mContext,view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

         viewHolder.userName.setText(posts.get(i).getUserName());
         viewHolder.desc.setText(posts.get(i).getDesc());
         viewHolder.numLikes.setText(posts.get(i).getNumLikes());
         viewHolder.datePosted.setText(posts.get(i).getDatePosted());


        String mainImg = posts.get(i).getMainImgUrl();
        String profileImg= posts.get(i).getProfileImgUrl();

        // Picasso.get().load(posts.get(i).getMainImgUrl()).into(viewHolder.mainImgUrl);
        //Picasso.get().load(posts.get(i).getProfileImgUrl()).into(viewHolder.profileImg);
        Picasso.with(mContext)
                .load(mainImg)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(viewHolder.mainImgUrl);

        Picasso.with(mContext)
                .load(profileImg)
                .placeholder(android.R.drawable.sym_def_app_icon)
                .error(android.R.drawable.sym_def_app_icon)
                .into(viewHolder.profileImg);

        Post currentPost = posts.get(i);
        viewHolder.mCurrentPost = currentPost;
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
       private Context mContext;
       Post mCurrentPost;


        ViewHolder(Context context,View itemView) {
            super(itemView);

            profileImg = itemView.findViewById(R.id.profileImg);
            userName = itemView.findViewById(R.id.userName);
            mainImgUrl = itemView.findViewById(R.id.mainImg);
            desc = itemView.findViewById(R.id.desc);
            numLikes = itemView.findViewById(R.id.numLikes);
            iconLike = itemView.findViewById(R.id.icon);
            datePosted = itemView.findViewById(R.id.datePosted);
            rl = itemView.findViewById(R.id.rl);
            mContext=context;




            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            Intent commentIntent = new Intent(mContext, Comments.class);

            commentIntent.putExtra(POST_KEY,mCurrentPost.getId());


            commentIntent.putExtra(IMAGE_KEY, mCurrentPost.getMainImgUrl());

            mContext.startActivity(commentIntent);
        }

    }

}


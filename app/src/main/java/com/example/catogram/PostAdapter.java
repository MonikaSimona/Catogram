package com.example.catogram;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    public ArrayList<Post> posts;
    public Context context;

    public PostAdapter(ArrayList<Post> posts, Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_posts,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(posts.get(i));

        viewHolder.profileImg.setImageURI(Uri.parse(posts.get(i).getProfileImgUrl()));
        viewHolder.userName.setText(posts.get(i).getUserName());
        viewHolder.mainImgUrl.setImageURI(Uri.parse(posts.get(i).getUserName()));
        viewHolder.desc.setText(posts.get(i).getDesc());
        viewHolder.numLikes.setText(posts.get(i).getNumLikes());
        viewHolder.datePosted.setText((Integer) posts.get(i).getDatePosted());

        viewHolder.rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"clicked",Toast.LENGTH_SHORT).show();            }
        });
    }
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView profileImg;
        TextView userName;
        ImageView mainImgUrl;
        TextView desc;
        TextView numLikes;
        ImageButton iconLike;
        TextView datePosted;
        RelativeLayout rl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImg = itemView.findViewById(R.id.profileImg);
            userName = itemView.findViewById(R.id.userName);
            mainImgUrl = itemView.findViewById(R.id.mainImg);
            desc = itemView.findViewById(R.id.desc);
            numLikes = itemView.findViewById(R.id.numLikes);
            iconLike = itemView.findViewById(R.id.icon);
            datePosted = itemView.findViewById(R.id.datePosted);
            rl = itemView.findViewById(R.id.rl);


        }
    }
}


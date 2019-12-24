package com.example.catogram;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    public ArrayList<Comment> comments;
    public Context mContext;

    public CommentAdapter(ArrayList<Comment> comments, Context mContext) {
        this.comments = comments;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.layout_comment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Comment

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        private CircleImageView comProfileImg;
        private TextView comUserName;
        private TextView comment;

        public ViewHolder(Context context,@NonNull View itemView) {
            super(itemView);

            comProfileImg=itemView.findViewById(R.id.comProfileImg);
            comUserName=itemView.findViewById(R.id.comUserName);
            comment=itemView.findViewById(R.id.comment);
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }


        @Override
        public void onClick(View v) {

        }
    }
}

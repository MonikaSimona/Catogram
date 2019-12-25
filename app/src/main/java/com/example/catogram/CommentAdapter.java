package com.example.catogram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private ArrayList<Comment> comments ;
    private Context mContext;

    public CommentAdapter(ArrayList<Comment> comments, Context mContext) {
        this.comments = comments;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        return new ViewHolder(mContext, LayoutInflater.from(mContext)
                .inflate(R.layout.layout_comment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.comUserName.setText(comments.get(position).getComUserName());
        holder.comment.setText(comments.get(position).getComment());
        holder.datePosted.setText(comments.get(position).getDatePosted());
        Picasso.get().load(comments.get(position).getComProfileImg()).into(holder.comProfileImg);



    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener

    {
        private CircleImageView comProfileImg;
        private TextView comUserName;
        private TextView comment;
        private TextView datePosted;


        ViewHolder(Context mContext, @NonNull View itemView) {
            super(itemView);
            comProfileImg=itemView.findViewById(R.id.comProfileImg);
            comUserName=itemView.findViewById(R.id.comUserName);
            comment=itemView.findViewById(R.id.comment);
            datePosted=itemView.findViewById(R.id.datePosted);

        }

        @Override
        public void onClick(View v) {

        }
    }
}

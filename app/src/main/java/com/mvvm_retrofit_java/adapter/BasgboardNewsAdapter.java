package com.mvvm_retrofit_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mvvm_retrofit_java.R;
import com.mvvm_retrofit_java.model.Article;

import java.util.ArrayList;

public class BasgboardNewsAdapter extends RecyclerView.Adapter<BasgboardNewsAdapter.ViewHolder> {

    private final Context context;
    ArrayList<Article> articleArrayList;

    public BasgboardNewsAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_each_article,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Article article = articleArrayList.get(i);
        viewHolder.tvTitle.setText(article.getTitle());
        /*viewHolder.tvAuthorAndPublishedAt.setText("-"+article.getAuthor() +" | "+"Published At: "+article.getPublishedAt());
        viewHolder.tvDescription.setText(article.getDescription());*/
        Glide.with(context)
                .load(article.getUrlToImage())
                .into(viewHolder.imgViewCover);
    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgViewCover;
        private final TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgViewCover = itemView.findViewById(R.id.imgViewCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}

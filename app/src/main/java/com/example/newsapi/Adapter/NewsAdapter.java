package com.example.newsapi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapi.Model.ArticlesItem;
import com.example.newsapi.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<ArticlesItem> newsItem = new ArrayList<>();
    private Context context;

    public NewsAdapter(Context context) {
        this.context = context;
    }


    public void setData(ArrayList<ArticlesItem> items){
        newsItem.clear();
        newsItem.addAll(items);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(newsItem.get(position).getUrlToImage())
                .into(holder.ivJudul);
        holder.tvJudul.setText(newsItem.get(position).getTitle());
        holder.tvAuthor.setText(newsItem.get(position).getAuthor());
        holder.item_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webBrowser = Uri.parse(newsItem.get(position).getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, webBrowser);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivJudul;
        TextView tvJudul, tvAuthor;
        CardView item_news;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_news = itemView.findViewById(R.id.item_news);
            ivJudul = itemView.findViewById(R.id.ivJudul);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
        }
    }
}

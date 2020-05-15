package com.example.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsapi.Adapter.NewsAdapter;
import com.example.newsapi.Model.ArticlesItem;
import com.example.newsapi.View.NewsViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private NewsAdapter adapter;
    private RecyclerView recyclerView;
    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new NewsAdapter(getApplicationContext());
        adapter.notifyDataSetChanged();

        recyclerView = findViewById(R.id.rvNews);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));

        newsViewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        newsViewModel.setNews();
        newsViewModel.getNews().observe(this, getNews);

        recyclerView.setAdapter(adapter);

    }

    private Observer<ArrayList<ArticlesItem>> getNews = new Observer<ArrayList<ArticlesItem>>() {
        @Override
        public void onChanged(ArrayList<ArticlesItem> articlesItems) {
            if(articlesItems != null){
                adapter.setData(articlesItems);
            }
        }
    };
}

package com.example.newsapi.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapi.Model.ArticlesItem;
import com.example.newsapi.Model.NewsResponse;
import com.example.newsapi.Service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ArticlesItem>> listNews = new MutableLiveData<>();

    public void setNews(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiNews().getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                NewsResponse responseNews = response.body();
                if (responseNews != null && responseNews.getArticles() != null){
                    ArrayList<ArticlesItem> newsItem = responseNews.getArticles();
                    listNews.postValue(newsItem);
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ArticlesItem>> getNews(){
        return listNews;
    }
}

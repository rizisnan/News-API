package com.example.newsapi.Service;

import com.example.newsapi.Model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsRepository {
    @GET("v2/top-headlines?country=id&apiKey=130c653cb15a4c6694f0dc37ff464f0c")
    Call<NewsResponse> getNews();
}

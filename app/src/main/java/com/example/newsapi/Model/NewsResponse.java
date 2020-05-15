package com.example.newsapi.Model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewsResponse{

	@SerializedName("totalResults")
	private Integer totalResults;

	@SerializedName("articles")
	private ArrayList<ArticlesItem> articles;

	@SerializedName("status")
	private String status;

	public void setTotalResults(Integer totalResults){
		this.totalResults = totalResults;
	}

	public Integer getTotalResults(){
		return totalResults;
	}

	public void setArticles(ArrayList<ArticlesItem> articles){
		this.articles = articles;
	}

	public ArrayList<ArticlesItem> getArticles(){
		return articles;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}
package com.mvvm_retrofit_java.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mvvm_retrofit_java.model.Article;

import java.util.List;

public class ArticleResponse {
    @SerializedName("articles")
    @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "BashboardNewsResponse{" +
                "articles=" + articles +
                '}';
    }
}

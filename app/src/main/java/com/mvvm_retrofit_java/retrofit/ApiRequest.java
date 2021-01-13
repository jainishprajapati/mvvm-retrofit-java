package com.mvvm_retrofit_java.retrofit;

import com.mvvm_retrofit_java.response.ArticleResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.mvvm_retrofit_java.constants.AppConstant.API_KEY;

public interface ApiRequest {

    @GET("top-headlines?country=de&category=business&apiKey="+API_KEY)
    Call<ArticleResponse> getTopHeadlines();

}

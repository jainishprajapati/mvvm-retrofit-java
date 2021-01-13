package com.mvvm_retrofit_java.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mvvm_retrofit_java.response.ArticleResponse;
import com.mvvm_retrofit_java.retrofit.ApiRequest;
import com.mvvm_retrofit_java.retrofit.RetrofitRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private static final String TAG = ArticleRepository.class.getSimpleName();
    private final ApiRequest apiRequest;

    public ArticleRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<ArticleResponse> getDashBoardNews() {
        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getTopHeadlines()
                .enqueue(new Callback<ArticleResponse>() {


                    @Override
                    public void onResponse(@NonNull Call<ArticleResponse> call,
                                           @NonNull Response<ArticleResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                            Log.d(TAG, "articles total result:: " + response.body());
                            Log.d(TAG, "size:: " + response.body().getArticles().size());
//                            Log.d(TAG, "articles title pos 0:: " + response.body().getArticles().get(0).getTitle());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ArticleResponse> call, @NonNull Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}

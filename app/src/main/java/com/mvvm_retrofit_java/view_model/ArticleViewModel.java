package com.mvvm_retrofit_java.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mvvm_retrofit_java.repository.ArticleRepository;
import com.mvvm_retrofit_java.response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleResponse;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);

        articleResponse = new ArticleRepository();
        this.articleResponseLiveData = articleResponse.getDashBoardNews();
    }

    public LiveData<ArticleResponse> getBashboardNewsResponseLiveData() {
        return articleResponseLiveData;
    }
}

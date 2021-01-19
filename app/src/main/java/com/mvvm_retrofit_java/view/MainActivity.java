package com.mvvm_retrofit_java.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.mvvm_retrofit_java.R;
import com.mvvm_retrofit_java.adapter.MovieArticleAdapter;
import com.mvvm_retrofit_java.model.Article;
import com.mvvm_retrofit_java.view_model.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recycler_view;
    private ProgressBar progress_bar;

    private LinearLayoutManager layoutManager;
    private ArrayList<Article> articleArrayList = new ArrayList<>();
    ArticleViewModel articleViewModel;
    private MovieArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        getArticles();
    }

    private void init() {
        progress_bar = findViewById(R.id.progress_bar);
        recycler_view = findViewById(R.id.recycler_view);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recycler_view.setLayoutManager(layoutManager);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recycler_view.setHasFixedSize(true);

        // adapter
        adapter = new MovieArticleAdapter(MainActivity.this, articleArrayList);
        recycler_view.setAdapter(adapter);

        // View Model
        articleViewModel = ViewModelProviders.of(this).get(ArticleViewModel.class);
    }

    private void getArticles() {
        articleViewModel.getBashboardNewsResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null  && articleResponse.getArticles() != null
                    && !articleResponse.getArticles().isEmpty()) {
                progress_bar.setVisibility(View.GONE);
                List<Article> articleList = articleResponse.getArticles();
                articleArrayList.addAll(articleList);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
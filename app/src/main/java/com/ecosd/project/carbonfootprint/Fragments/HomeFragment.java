package com.ecosd.project.carbonfootprint.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecosd.project.carbonfootprint.CustomGridTopics;
import com.ecosd.project.carbonfootprint.Others.PrefManager;
import com.ecosd.project.carbonfootprint.R;

import java.util.List;

import Interfaces.API_Interface;
import Models.Article;
import Models.ArticleStructure;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by this pc on 10-04-17.
 */

public class HomeFragment extends Fragment {

    private View view;
    private RecyclerView.LayoutManager layoutManager;
    CustomGridTopics adapter;
    RecyclerView recyclerView;
    ProgressDialog dialog;
    List<ArticleStructure> articleList;
    PrefManager pref;

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.news_list,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.news_grid);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        pref=new PrefManager(getActivity());
        getArticles();

        return view;
    }

    public void getArticles()
    {
        API_Interface.Factory.getInstance().getNews().enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {

                Log.e("Articleeeeeeeee", response.body().toString());
                for (int i = 0; i < response.body().articles.size(); i++) {
                    articleList = response.body().articles;
                }
                Log.e("Articleeeeeeeee", articleList.toString());
                adapter = new CustomGridTopics(getActivity(), articleList, new CustomGridTopics.VenueAdapterClickCallbacks() {
                    @Override
                    public void onCardClick(String p) {

                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(p));
                        startActivity(browserIntent);

                    }

                    @Override
                    public void onShareClick(String a) {

                    }

                });
                recyclerView.setAdapter(adapter);


            }
            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });


    }
}

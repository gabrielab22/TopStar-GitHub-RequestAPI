package com.example.topstargithubrepos_javaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        //final RecyclerView.Adapter adapter = new MyAdapter(arrayList);
        //recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<Items> call = api.getRepositories();

        call.enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Log.d("Success","onResposne: " + response.toString());
                ArrayList<Repository> repositories = response.body().getRepositories();

                final RecyclerView.Adapter adapter = new MyAdapter(repositories);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Log.e("Error","onFailure: Something went wrong: " + t.getMessage());
            }
        });
    }
}
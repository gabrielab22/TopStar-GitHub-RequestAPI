package com.example.topstargithubrepos_javaapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {
    @Headers("Content-Type: application/json")
    @GET("search/repositories?q=stars:>=100000&sort=stars&order=desc")
    Call<Items> getRepositories();
}

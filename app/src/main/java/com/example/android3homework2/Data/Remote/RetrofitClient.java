package com.example.android3homework2.Data.Remote;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private final OkHttpClient client =
            new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build();

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://android-3-mocker.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public PostApi provideApi(){
        return retrofit.create(PostApi.class);
    }
}

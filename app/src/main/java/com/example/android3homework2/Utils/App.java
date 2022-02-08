package com.example.android3homework2.Utils;

import android.app.Application;

import com.example.android3homework2.Data.Remote.PostApi;
import com.example.android3homework2.Data.Remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient client;
    public static PostApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        client = new RetrofitClient();
        api = client.provideApi();
    }
}

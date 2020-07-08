package com.nycapp.nycaid.Network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NycAidRetrofit {

    private static final String BASE_URL = "https://raw.githubusercontent.com/rosannaNaomy/covidNYCFiles/master/";

    private static Retrofit retrofitInstance;

    public NycAidRetrofit() {
    }

    public static Retrofit getRetrofitInstance(){
        if (retrofitInstance == null){
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}

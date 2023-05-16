package com.ion_popescu.laborator4.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientApi {
    public static Retrofit addTheAddressOfTheApi(String address){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(address)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}

package com.ion_popescu.laborator4.services;

import com.ion_popescu.laborator4.repo.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DataRetrievalService {
    @GET("api/v1/users/getUsers/{username}")
    Call<User> getUser(@Path("username") String username);

}

package com.example.recyclerview.remote.retrofit;
import com.example.recyclerview.model.ApiGitHub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

//quan ly viec truy xuat voi server
public interface SOService {
 
   @GET("users")
   Call<List<ApiGitHub>> EXAMPLE_CALL();

}
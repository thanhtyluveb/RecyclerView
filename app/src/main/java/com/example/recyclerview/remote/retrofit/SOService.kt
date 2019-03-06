package com.example.recyclerview.remote.retrofit

import com.example.recyclerview.model.ApiGitHub

import retrofit2.Call
import retrofit2.http.GET

//quan ly viec truy xuat voi server
interface SOService {

    @GET("users")
    fun EXAMPLE_CALL(): Call<List<ApiGitHub>>

}
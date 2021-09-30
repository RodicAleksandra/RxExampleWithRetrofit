package com.example.rxexamplewithretrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object ApiClient {

    private val myRetrofit by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val r = Retrofit.Builder()
            .baseUrl("https://grocery-second-app.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        r   // return value of lambda expression
    }

    val apiService: ApiService by lazy {
        myRetrofit.create(ApiService::class.java)
    }
}
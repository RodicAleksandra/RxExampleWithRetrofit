package com.example.rxexamplewithretrofit

import com.example.rxexamplewithretrofit.RegisterRequestData
import com.example.rxexamplewithretrofit.RegisterResponseData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*

interface ApiService {


    @Headers("Content-type: application/json")
    @POST("auth/register")
    fun register(
        @Body loginData: RegisterRequestData
    ): Observable<RegisterResponseData>


}
package com.example.rxexamplewithretrofit


data class RegisterResponseData(
    val error: Boolean?,
    val message: String?,
    val data: Data?
)

data class Data(

    val firstName: String,
    val _id: String,
    val mobile: String,
    val password: String,
    val email: String,
    val createdAt: String,
    val __v: Int


)


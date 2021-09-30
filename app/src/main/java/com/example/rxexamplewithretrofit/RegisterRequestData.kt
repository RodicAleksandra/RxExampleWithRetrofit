package com.example.rxexamplewithretrofit

data class RegisterRequestData (
    val name: String,
    val mobile: String,
    val password: String,
    val email: String
)
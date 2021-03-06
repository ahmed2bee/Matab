package com.beefirstOvators.matab.model

data class LoginResponse(
    val `data`: User,
    val message: String,
    val status: Boolean
)

data class User(
    val email: String,
    val token: String
)
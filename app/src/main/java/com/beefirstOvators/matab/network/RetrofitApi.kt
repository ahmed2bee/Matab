package com.beefirstOvators.matab.network

import com.beefirstOvators.matab.model.ForgetPasswordResponse
import com.beefirstOvators.matab.model.LoginResponse
import com.beefirstOvators.matab.model.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitApi {

    @FormUrlEncoded
    @POST("account/login/")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<LoginResponse>

//    @GET("product/category/?")
//    suspend fun getCategories(
//        @Query("section") brandName: String,
//    ): Response<CategoryResponse>

    @FormUrlEncoded
    @POST("password_reset/")
    suspend fun sendEmailResetPassword(
        @Field("email") email: String,
    ): Response<ForgetPasswordResponse>

    @FormUrlEncoded
    @POST("password_reset/confirm/")
    suspend fun resetPasswordConfirm(
        @Field("token") code: String,
        @Field("password") password: String,
    ): Response<ForgetPasswordResponse>

    @FormUrlEncoded
    @POST("password_reset/validate_token/")
    suspend fun emailCodeValidation(
        @Field("token") code: String,
    ): Response<ForgetPasswordResponse>

    @FormUrlEncoded
    @POST("account/register/")
    suspend fun register(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("password2") password2: String,
    ): Response<RegistrationResponse>
}
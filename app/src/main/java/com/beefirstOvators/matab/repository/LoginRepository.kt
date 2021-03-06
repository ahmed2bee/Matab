package com.beefirstOvators.matab.repository

import android.util.Log
import com.beefirstOvators.matab.model.LoginResponse
import com.beefirstOvators.matab.network.RetrofitApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val retrofit: RetrofitApi
) {
    suspend fun login(
        email: String,
        password: String
    ): LoginResponse? {

        return try {
            val response = retrofit.login(email, password)
            when (response.isSuccessful) {
                true -> {
                    Log.i("infooResponse", "login: ${response.body()?.data}")
                    response.body()
                }
                false -> {
                    Log.e("infooResponseError", "login: ${response.message()} ${response.code()}", )
                    null
                }
            }
        } catch (e: Exception) {
            Log.e("ErrorConnection", "${e.message} <<<")
            null
        }
    }
}
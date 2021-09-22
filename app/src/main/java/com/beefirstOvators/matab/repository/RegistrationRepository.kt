package com.beefirstOvators.matab.repository

import android.util.Log
import com.beefirstOvators.matab.model.RegistrationResponse
import com.beefirstOvators.matab.network.RetrofitApi
import javax.inject.Inject

class RegistrationRepository @Inject constructor(
    private val retrofit: RetrofitApi,
) {
    suspend fun register(
        email: String,
        username: String,
        password: String,
        password2: String,
    ): RegistrationResponse? {

        return try {
            val response = retrofit.register(email, username, password, password2)
            when (response.isSuccessful) {
                true -> response.body()
                false -> null
            }
        } catch (e: Exception) {
            Log.e("ErrorConnection", "${e.message} <<<")
            null
        }
    }
}
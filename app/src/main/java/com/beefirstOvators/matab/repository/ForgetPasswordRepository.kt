package com.beefirstOvators.matab.repository

import android.util.Log
import com.beefirstOvators.matab.model.ForgetPasswordResponse
import com.beefirstOvators.matab.network.RetrofitApi
import javax.inject.Inject

class ForgetPasswordRepository @Inject constructor(
    private val retrofit: RetrofitApi,
) {
    suspend fun sendEmailForgetPassword(emailAddress: String): ForgetPasswordResponse? {

        return try {
            val response = retrofit.sendEmailResetPassword(emailAddress)
            when (response.isSuccessful) {
                true -> response.body()
                false -> null
            }
        } catch (e: Exception) {
            Log.e("ErrorConnection", "${e.message} <<<")
            null
        }
    }

    suspend fun resetPassword(code: String, password: String): ForgetPasswordResponse? {

        return try {
            val response = retrofit.resetPasswordConfirm(code, password)
            when (response.isSuccessful) {
                true -> response.body()
                false -> null
            }
        } catch (e: Exception) {
            Log.e("ErrorConnection", "${e.message} <<<")
            null
        }
    }

    suspend fun codeValidation(code: String): ForgetPasswordResponse? {
        return try {
            val response = retrofit.emailCodeValidation(code)
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
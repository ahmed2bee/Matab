package com.beefirstOvators.matab.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beefirstOvators.matab.model.LoginResponse
import com.beefirstOvators.matab.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository,
) : ViewModel() {

    private val _loginData: MutableLiveData<LoginResponse> by lazy { MutableLiveData() }
    val loginData: LiveData<LoginResponse> get() = _loginData

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginData.postValue(repository.login(email, password))
        }
    }
}
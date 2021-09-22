package com.beefirstOvators.matab.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.beefirstOvators.matab.model.RegistrationResponse
import com.beefirstOvators.matab.repository.RegistrationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: RegistrationRepository,
) : ViewModel() {

    private val _registration: MutableLiveData<RegistrationResponse> by lazy { MutableLiveData() }
    val registration: LiveData<RegistrationResponse> get() = _registration

    fun register(email: String, username: String, password: String, password2: String) {
        viewModelScope.launch {
            _registration.postValue(repository.register(email, username, password, password2))
        }
    }
}
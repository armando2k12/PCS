package com.armando.pos_armando.ui.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.armando.pos_armando.data.model.ActionState
import com.armando.pos_armando.data.model.AuthUser
import com.armando.pos_armando.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(val repo : AuthRepository) : ViewModel() {
    val authUser = repo.authUser
    val isLogin = repo.islogin
    val authLogin = MutableLiveData<ActionState<AuthUser>>()
    val authRegister = MutableLiveData<ActionState<AuthUser>>()
    val authSignout = MutableLiveData<ActionState<Boolean>>()


    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val fullname = MutableLiveData<String>()

    fun login() {
        viewModelScope.launch {
            val resp = repo.login(email.value ?: "", password.value ?: "")
            authLogin.value = resp
        }
    }

    fun register() {
        viewModelScope.launch {
            val resp = repo.register(
                AuthUser(
                    email = email.value ?: "",
                    password = password.value ?: "",
                    fullname = fullname.value ?: ""
                )
            )
            authRegister.value = resp
        }
    }

    fun signout() {
        viewModelScope.launch {
            val resp = repo.signout()
            authSignout.value = resp
        }
    }
}
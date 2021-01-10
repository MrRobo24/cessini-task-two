package com.arpit.cessini_task_two.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arpit.cessini_task_two.R
import com.arpit.cessini_task_two.databinding.ActivitySignInBinding
import com.arpit.cessini_task_two.viewmodel.SignInViewModel

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding
    lateinit var signInViewModel: SignInViewModel
    val defaultUrl = "https://i.ytimg.com/vi/Zpvv9TdQU2k/maxresdefault.jpg"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
        signInViewModel = ViewModelProvider(this).get(SignInViewModel::class.java)
        binding.scontext = this
        binding.viewmodel = signInViewModel
        binding.lifecycleOwner = this

        signInViewModel.imgUrl.value = defaultUrl
        signInViewModel.txtLoginButton.value = "Log In"


        signInViewModel.emailText.observe(this, Observer {
            if (signInViewModel.isEmailValid(it?.toString())) {
                Log.d("EmailText", it.toString())
                signInViewModel.emailError.value = null
            } else {
                if (signInViewModel.imgUrl.value != defaultUrl) {
                    signInViewModel.imgUrl.value = defaultUrl
                }
                signInViewModel.emailError.value = "This email is not valid"
            }
        })

        signInViewModel.passwordText.observe(this, Observer {
            if (signInViewModel.isPasswordValid(it?.toString())) {
                Log.d("PasswordText", "Password Valid")
                signInViewModel.passError.value = null
            } else {
                if (signInViewModel.imgUrl.value != defaultUrl) {
                    signInViewModel.imgUrl.value = defaultUrl
                }
                signInViewModel.passError.value = "This password is not valid"
            }
        })
    }
}
package com.arpit.cessini_task_two

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.arpit.cessini_task_two.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ViewModel
    val defaultUrl = "https://i.ytimg.com/vi/Zpvv9TdQU2k/maxresdefault.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        binding.mcontext = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.imgUrl.value = defaultUrl
        viewModel.txtLoginButton.value = "Log In"

        viewModel.emailText.observe(this, Observer {
            if (viewModel.isEmailValid(it?.toString())) {
                Log.d("EmailText", it.toString())
                viewModel.emailError.value = null
            } else {
                if (viewModel.imgUrl.value != defaultUrl) {
                    viewModel.imgUrl.value = defaultUrl
                }
                viewModel.emailError.value = "This email is not valid"
            }
        })

        viewModel.passwordText.observe(this, Observer {
            if (viewModel.isPasswordValid(it?.toString())) {
                Log.d("PasswordText", "Password Valid")
                viewModel.passError.value = null
            } else {
                if (viewModel.imgUrl.value != defaultUrl) {
                    viewModel.imgUrl.value = defaultUrl
                }
                viewModel.passError.value = "This password is not valid"
            }
        })

    }
}
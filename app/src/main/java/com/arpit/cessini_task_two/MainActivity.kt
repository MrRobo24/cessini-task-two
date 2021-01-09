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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.etEmail.observe(this, Observer {
            Log.d("TextWatcher", it)
        })

        viewModel.emailText.observe(this, Observer {
            if (viewModel.isEmailValid(it.toString())) {
                Log.d("EmailText", it.toString())
                viewModel.error.value = null
            } else {
                viewModel.error.value = "This email is not valid"
            }
        })

    }
}
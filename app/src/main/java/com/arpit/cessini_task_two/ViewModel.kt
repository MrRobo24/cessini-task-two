package com.arpit.cessini_task_two

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {
    var txtData = MutableLiveData<String>()
    var txtLoginButton = MutableLiveData<String>()
    var etEmail = MutableLiveData<String>()

    fun onClick(view: View) {
        txtData.value = "Email Accepted"
        txtLoginButton.value = "Login Successful"
    }

//    var emailTextWatcher: TextWatcher = object : TextWatcher {
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//        }
//
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            Log.d("TextWatcher", s.toString())
//        }
//
//        override fun afterTextChanged(s: Editable?) {
//
//        }
//
//    }
}
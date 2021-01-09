package com.arpit.cessini_task_two

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class ViewModel : ViewModel() {
    var txtData = MutableLiveData<String>()
    var txtLoginButton = MutableLiveData<String>()
    var etEmail = MutableLiveData<String>()
    var error = MutableLiveData<String>()
    var emailText = MutableLiveData<String>()
    var imgUrl = MutableLiveData<String>()

    fun onClick(view: View) {
        txtData.value = "Email Accepted"
        txtLoginButton.value = "Login Successful"
    }

    fun isEmailValid(email: String?): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
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
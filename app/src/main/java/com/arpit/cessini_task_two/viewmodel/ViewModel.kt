package com.arpit.cessini_task_two.viewmodel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

open class ViewModel : ViewModel() {

    var txtLoginButton = MutableLiveData<String>()
    var emailError = MutableLiveData<String>()
    var passError = MutableLiveData<String>()
    var emailText = MutableLiveData<String>()
    var passwordText = MutableLiveData<String>()
    var imgUrl = MutableLiveData<String>()

    fun onClick(view: View) {
        if (isEmailValid(emailText.value) && isPasswordValid(passwordText.value)) {
            txtLoginButton.value = "Log In Successful"
            imgUrl.value =
                "https://www.kindpng.com/picc/m/3-30961_deal-with-it-android-cool-android-logo-png.png"
        } else {
            txtLoginButton.value = "Log In Failed! Try Again"
        }
    }

    fun isEmailValid(email: String?): Boolean {
        if (email == null) {
            return false
        }
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern: Pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun isPasswordValid(password: String?): Boolean {
        if (password == null ||
            password.length < 6
        ) {
            return false
        }

        return true
    }
}
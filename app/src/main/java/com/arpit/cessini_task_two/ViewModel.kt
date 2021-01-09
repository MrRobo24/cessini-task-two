package com.arpit.cessini_task_two
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    var txtEmail = MutableLiveData<String>()
    var txtLoginButton =  MutableLiveData<String>()

    fun onClick(view: View) {
        txtEmail.value = "Email Accepted"
        txtLoginButton.value = "Login Successful"
    }
}
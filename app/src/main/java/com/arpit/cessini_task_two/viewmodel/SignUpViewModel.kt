package com.arpit.cessini_task_two.viewmodel

import androidx.lifecycle.MutableLiveData

class SignUpViewModel : ViewModel() {

    var txtEmail = MutableLiveData<String>()
    var txtUsername = MutableLiveData<String>()
    var txtPassword = MutableLiveData<String>()
    var txtSignUpButton = MutableLiveData<String>()
}
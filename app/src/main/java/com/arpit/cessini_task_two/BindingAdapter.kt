package com.arpit.cessini_task_two

import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

//@BindingAdapter("app:textwatcher")
//fun watcher(view: EditText, textWatcher: TextWatcher) {
//    view.addTextChangedListener(textWatcher)
//}

@BindingAdapter("app:error")
fun error(view: TextInputLayout, errorString: String?) {
    view.isErrorEnabled = true
    view.error = errorString
}
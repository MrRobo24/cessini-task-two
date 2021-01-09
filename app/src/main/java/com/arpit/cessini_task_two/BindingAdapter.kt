package com.arpit.cessini_task_two

import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("app:textwatcher")
fun watcher(view: EditText, textWatcher: TextWatcher) {
    view.addTextChangedListener(textWatcher)
}
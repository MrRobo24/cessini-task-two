package com.arpit.cessini_task_two.adapter

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.arpit.cessini_task_two.R
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("tilError")
fun tilError(view: TextInputLayout, errorString: String?) {
    view.isErrorEnabled = true
    view.error = errorString
}


@BindingAdapter(value = ["imageUrl", "context"], requireAll = true)
fun image(view: ImageView, url: String?, context: Context) {
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.mipmap.ic_launcher)
        .into(view);
}
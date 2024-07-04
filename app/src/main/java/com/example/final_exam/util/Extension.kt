package com.example.test.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.final_exam.R

fun ImageView.imageLoader(url: String) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(this)
}
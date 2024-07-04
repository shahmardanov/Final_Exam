package com.example.test.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("setImageFromUrl")
fun loadImage(imageView: ImageView, url: String){
    imageView.imageLoader(url)
}
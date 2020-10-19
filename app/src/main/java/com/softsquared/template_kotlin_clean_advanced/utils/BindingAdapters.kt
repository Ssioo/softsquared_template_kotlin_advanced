package com.softsquared.template_kotlin_clean_advanced.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imgRes")
    fun bindImgRes(view: ImageView, @DrawableRes resId: Int) {
        view.setImageResource(resId)
    }
}
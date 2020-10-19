package com.softsquared.template_kotlin_clean_advanced.utils.objects

import com.google.gson.annotations.SerializedName

class BaseResponse<T> (
    @SerializedName("code") val code: Int,
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("data") val data: T?,
    @SerializedName("msg") val message: String?
)
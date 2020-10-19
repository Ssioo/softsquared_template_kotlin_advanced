package com.softsquared.template_kotlin_clean_advanced.data.remote

import com.softsquared.template_kotlin_clean_advanced.utils.Constants.X_ACCESS_TOKEN
import com.softsquared.template_kotlin_clean_advanced.ApplicationClass.Companion.sharedPref
import okhttp3.Interceptor
import okhttp3.Response

class XAccessTokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        sharedPref?.getString(X_ACCESS_TOKEN, null)?.let {
            builder.addHeader(X_ACCESS_TOKEN, it)
        }
        return chain.proceed(builder.build())
    }
}
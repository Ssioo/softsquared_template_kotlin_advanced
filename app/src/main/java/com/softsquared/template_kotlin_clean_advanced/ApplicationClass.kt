package com.softsquared.template_kotlin_clean_advanced

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.softsquared.template_kotlin_clean_advanced.utils.Constants
import com.softsquared.template_kotlin_clean_advanced.utils.Constants.APP_TAG
import com.softsquared.template_kotlin_clean_advanced.utils.Constants.CONNECT_TIMEOUT
import com.softsquared.template_kotlin_clean_advanced.utils.Constants.READ_TIMEOUT
import com.softsquared.template_kotlin_clean_advanced.data.remote.XAccessTokenInterceptor
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApplicationClass: Application() {

    companion object {
        var sharedPref: SharedPreferences? = null

        var httpClient = OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor { message ->
                if (message.startsWith("{") && message.endsWith("}")) {
                    Logger.t("OKHTTP").json(message)
                } else {
                    Log.i("OKHTTP", message)
                }
            }.apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(httpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        sharedPref = applicationContext.getSharedPreferences(APP_TAG, MODE_PRIVATE)

        Logger.addLogAdapter(object : AndroidLogAdapter(
            PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(0)
                .build()
        ) {
            override fun isLoggable(priority: Int, tag: String?): Boolean = BuildConfig.DEBUG
        })
    }
}
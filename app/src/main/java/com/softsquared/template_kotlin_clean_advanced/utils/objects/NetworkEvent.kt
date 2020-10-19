package com.softsquared.template_kotlin_clean_advanced.utils.objects

import androidx.lifecycle.MutableLiveData

class NetworkEvent: MutableLiveData<NetworkEvent.NetworkState>() {

    enum class NetworkState {
        LOADING, FAILURE, SUCCESS, ERROR
    }

    fun startLoading() {
        value = NetworkState.LOADING
    }

    fun clear() {
        value = NetworkState.SUCCESS
    }

    fun handleResponse(response : BaseResponse<*>?) {
        value = response?.let {
            if (it.code.toString().startsWith("4") || it.code.toString().startsWith("5")) NetworkState.SUCCESS
            else NetworkState.FAILURE
        } ?: NetworkState.ERROR
    }
}
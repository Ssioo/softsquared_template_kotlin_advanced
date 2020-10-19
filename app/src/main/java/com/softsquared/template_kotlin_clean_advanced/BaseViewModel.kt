package com.softsquared.template_kotlin_clean_advanced

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.softsquared.template_kotlin_clean_advanced.utils.objects.NetworkEvent
import com.softsquared.template_kotlin_clean_advanced.utils.objects.SingleEvent
import com.softsquared.template_kotlin_clean_advanced.utils.Union2
import io.reactivex.rxjava3.disposables.CompositeDisposable

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    protected val rxDisposable = CompositeDisposable()

    val toastEvent: MutableLiveData<SingleEvent<Union2<Int, String>>> = MutableLiveData()
    val alertEvent: MutableLiveData<SingleEvent<Union2<Int, String>>> = MutableLiveData()
    val networkEvent = NetworkEvent()

    override fun onCleared() {
        super.onCleared()
        if (!rxDisposable.isDisposed) rxDisposable.dispose()
    }

    open fun doOnNetworkError(error: Throwable?) {
        error?.printStackTrace()
        networkEvent.value = NetworkEvent.NetworkState.ERROR
        alertEvent.value = SingleEvent(Union2.A(R.string.network_error))
    }
}
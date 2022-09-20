package com.kgk.task1.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData

import com.kgk.task1.base.BaseViewModel
import com.kgk.task1.network.APIEndPoints
import com.kgk.task1.network.APIMethods
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val api: APIMethods) : BaseViewModel() {
    var fetchingData: MutableLiveData<Boolean> = MutableLiveData()
    var homeData: MutableLiveData<List<HomeResponse>> = MutableLiveData()
    var errorData: MutableLiveData<String> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getHomeData() {
        emitLoginData(showProgress = true)
        api.getHomeData(APIEndPoints.LIVE_URL + "photos")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                if (it.body() != null) {
                    emitLoginData(showProgress = false, response = it.body())
                } else {
                    emitLoginData(showProgress = false, error = "Error in load data")
                }
            }, { emitLoginData(showProgress = false, error = it.localizedMessage) })
    }

    private fun emitLoginData(
        showProgress: Boolean? = null, response: List<HomeResponse>? = null, error: String? = null,
    ) {
        fetchingData.postValue(showProgress)
        if (response != null) homeData.postValue(response)
        if (error != null) errorData.postValue(error)
    }
}

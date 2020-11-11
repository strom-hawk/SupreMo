package com.demoapps.supremo.viewmodel

import com.demoapps.supremo.interfaces.FlowCallBack
import com.demoapps.supremo.model.MainResponse
import com.demoapps.supremo.utils.ApplicationConstants
import com.demoapps.supremo.utils.RetrofitClient
import com.demoapps.supremo.utils.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/*
*This class is used as view model of home screen
*/

class HomeScreenViewModel(
    private var flowCallBack: FlowCallBack
) : BaseViewModel() {

    fun fireApi() {
        val apiServices = RetrofitClient.getApiClient(ApplicationConstants.BASE_URL)
        if (apiServices != null) {
            compositeDisposable?.add(
                apiServices.getApiServicesData(ApplicationConstants.BASE_URL+ Router.searchSuperHeroName)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.computation())
                    .subscribe({ response ->
                        handleResponse(response)
                    }, { error ->
                        handleError(error)
                    })
            )
        }
    }

    private fun handleResponse(mainResponse: MainResponse) {
        flowCallBack.onApiSuccess(mainResponse)
    }

    private fun handleError(error: Throwable) {
        flowCallBack.onApiFailed(error)
    }
}
package com.demoapps.supremo.interfaces

import com.demoapps.supremo.model.MainResponse

interface FlowCallBack {
    fun onApiCalled()
    fun onApiSuccess(mainResponse: MainResponse)
    fun onApiFailed(error: Throwable)
}
package com.demoapps.supremo.interfaces

import com.demoapps.supremo.model.MainResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiServices {
    @GET()
    fun getApiServicesData(@Url url: String): Observable<MainResponse>
}
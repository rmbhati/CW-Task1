package com.kgk.task1.network

import com.kgk.task1.ui.HomeResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIMethods {

    @GET
    fun getHomeData(@Url url: String): Observable<Response<List<HomeResponse>>>

}
package com.psquare.singlesourceoftruth.data.remote

import com.psquare.singlesourceoftruth.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface NyTimesBooksService {

    @GET("list/names.json")
    suspend fun getBookNames(@Query("api-key") apiKey: String = BuildConfig.API_KEY)

    companion object {
        const val BASE_URL = "https://api.nytimes.com/svc/books/v3/"
    }
}
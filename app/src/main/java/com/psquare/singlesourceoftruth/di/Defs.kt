package com.psquare.singlesourceoftruth.di

import android.content.Context
import androidx.room.Room
import com.psquare.singlesourceoftruth.BuildConfig
import com.psquare.singlesourceoftruth.db.VideoDB
import com.psquare.singlesourceoftruth.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

fun createOkHttpClient() : OkHttpClient {
    val builder = OkHttpClient.Builder()
    if (BuildConfig.DEBUG) {
        builder.addInterceptor(HttpLoggingInterceptor { message -> Timber.d(message) })
    }
    return builder.build()
}

fun createRetrofitClient(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

fun createDatabase(context: Context): VideoDB {
    return Room.databaseBuilder(context, VideoDB::class.java, Constants.DB_NAME).build()
}
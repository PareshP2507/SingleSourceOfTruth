package com.psquare.singlesourceoftruth.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val networkModule = module {
    single { createOkHttpClient() }
    single { createRetrofitClient(get()) }
}

val dbModule = module {
    single { createDatabase(androidContext()) }
}

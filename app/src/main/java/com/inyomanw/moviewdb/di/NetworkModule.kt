package com.inyomanw.moviewdb.di

import com.inyomanw.moviewdb.network.ApiClient
import org.koin.dsl.module.module

val networkModule = module {

    single { ApiClient().create() }
}
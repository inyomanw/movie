package com.inyomanw.moviewdb.di

import com.inyomanw.moviewdb.data.repository.MovieRepository
import com.inyomanw.moviewdb.data.repository.RemoteMovieDataSource
import org.koin.dsl.module.module

val dataModule = module {

    single { RemoteMovieDataSource(get()) }

    single { MovieRepository(get()) }
}
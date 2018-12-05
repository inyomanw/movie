package com.inyomanw.moviewdb.di

import com.inyomanw.moviewdb.ui.movie.MoviePresenter
import org.koin.dsl.module.module

val presenterModule = module {

    factory { MoviePresenter(get(),get()) }
}
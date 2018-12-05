package com.inyomanw.moviewdb.di

import com.inyomanw.moviewdb.ui.movie.MoviePresenter
import io.reactivex.disposables.CompositeDisposable
import org.koin.dsl.module.module

val schedulerModule = module {

    factory { CompositeDisposable() }
}
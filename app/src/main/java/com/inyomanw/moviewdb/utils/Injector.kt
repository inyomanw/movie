package com.inyomanw.moviewdb.utils

import com.inyomanw.moviewdb.data.repository.MovieRepository
import com.inyomanw.moviewdb.data.repository.RemoteMovieDataSource
import com.inyomanw.moviewdb.network.ApiClient
import com.inyomanw.moviewdb.ui.movie.MoviePresenter
import io.reactivex.disposables.CompositeDisposable

object Injector {
    fun provideMoviePresenter() = MoviePresenter(getMovieRepository(), getCompositeDisposable())

    fun getCompositeDisposable() =CompositeDisposable()
    fun getMovieRepository() = MovieRepository(provideRemoteMovieDataSource())

    fun provideRemoteMovieDataSource()= RemoteMovieDataSource(provideApiService())
    fun provideApiService() = ApiClient().create()
}
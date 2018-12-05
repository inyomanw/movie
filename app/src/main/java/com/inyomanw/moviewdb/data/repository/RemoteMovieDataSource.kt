package com.inyomanw.moviewdb.data.repository

import com.inyomanw.moviewdb.data.MoviesModel
import com.inyomanw.moviewdb.network.ApiService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RemoteMovieDataSource(val apiService: ApiService) : MovieDataSource {

    override fun getPopularMovies(): Observable<MoviesModel.ResponseModel> {
        return apiService.getPopularMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}
package com.inyomanw.moviewdb.network

import com.inyomanw.moviewdb.data.MoviesModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NetworkManager(val apiService: ApiService) {

    fun getMovie(onNext : (MoviesModel.ResponseModel) -> Unit,
                 onError : (Throwable) -> Unit ) = apiService
        .getPopularMovies()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(onNext, onError)
}
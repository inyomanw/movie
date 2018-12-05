package com.inyomanw.moviewdb.data.repository

import com.inyomanw.moviewdb.data.MoviesModel
import io.reactivex.Observable

class MovieRepository(val remoteMovieDataSource: RemoteMovieDataSource) {

    fun getPopularMovies() : Observable<MoviesModel.ResponseModel> = remoteMovieDataSource.getPopularMovies()
}
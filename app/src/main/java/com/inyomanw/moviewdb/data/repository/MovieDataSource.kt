package com.inyomanw.moviewdb.data.repository

import com.inyomanw.moviewdb.data.MoviesModel
import io.reactivex.Observable

interface MovieDataSource {
    fun getPopularMovies() : Observable<MoviesModel.ResponseModel>
}
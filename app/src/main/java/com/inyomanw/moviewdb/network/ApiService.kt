package com.inyomanw.moviewdb.network

import com.inyomanw.moviewdb.BuildConfig
import com.inyomanw.moviewdb.Constants.Companion.POPULAR_MOVIES
import com.inyomanw.moviewdb.data.MoviesModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(POPULAR_MOVIES)
    fun getPopularMovies(@Query("api_key") apiKey : String = BuildConfig.API_KEY)
        :Observable<MoviesModel.ResponseModel>
}
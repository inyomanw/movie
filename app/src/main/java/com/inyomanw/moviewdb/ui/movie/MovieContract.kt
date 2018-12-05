package com.inyomanw.moviewdb.ui.movie

import com.inyomanw.moviewdb.data.MoviesModel
import com.inyomanw.moviewdb.ui.base.BaseContract

interface MovieContract {

    interface Presenter : BaseContract.Presenter<View>{
        fun getPopularMovies()
    }

    interface View : BaseContract.View{
        fun showPopularMovies(movies : List<MoviesModel.Result>)
        fun onSuccessGetPopularMovies()
    }
}
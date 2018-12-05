package com.inyomanw.moviewdb.ui.movie

import com.inyomanw.moviewdb.data.repository.MovieRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class MoviePresenter(val movieRepository: MovieRepository,
                     val compositeDisposable: CompositeDisposable): MovieContract.Presenter {

    private var mViews: MovieContract.View? = null


    override fun onAttach(view: MovieContract.View) {
        //presenter view saling terkoneksi
        mViews = view
    }

    override fun onDetach() {
        mViews = null
    }
    override fun getPopularMovies() {

        movieRepository.getPopularMovies().subscribeBy(
            onNext = {
                mViews?.showPopularMovies(it.results)
                Timber.d("Success get movies")
            },
            onError = {
                Timber.e(it)
            },
            onComplete = {
                mViews?.onSuccessGetPopularMovies()
            }
        ).addTo(compositeDisposable)
    }
}
package com.inyomanw.moviewdb.ui.movie

import com.inyomanw.moviewdb.deps.ActivityScope
import com.inyomanw.moviewdb.network.NetworkManager
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

@ActivityScope
class MPresenter @Inject constructor(val networkManager: NetworkManager) : MovieContract.Presenter{
    private val compositeDisposable = CompositeDisposable()
    private var view :MovieContract.View? = null


    override fun getPopularMovies() {
        compositeDisposable.add(networkManager.getMovie({
            view?.showPopularMovies(it.results)
        },{
            Timber.e(it)
        }))
    }

    override fun onAttach(view: MovieContract.View) {
        this.view = view
    }
    override fun onDetach() {
        view = null
    }

}
package com.inyomanw.moviewdb.ui.movie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.inyomanw.moviewdb.data.MoviesModel
import com.inyomanw.moviewdb.R
import com.inyomanw.moviewdb.gone
import com.inyomanw.moviewdb.network.ApiClient
import com.inyomanw.moviewdb.network.ApiService
import com.inyomanw.moviewdb.utils.Injector
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MovieContract.View {

    @Inject
    lateinit var presenter :MPresenter

    private lateinit var movieAdapter: MovieAdapter
    private val movieList : MutableList<MoviesModel.Result> = mutableListOf()

//    private  val presenter : MoviePresenter by inject()

//    private lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        presenter = Injector.provideMoviePresenter()
        onAttachView()
        initRV()
        presenter.getPopularMovies()

    }
    fun initRV(){
        movieAdapter = MovieAdapter(movieList)
        rvPopularMovies.apply {
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter=movieAdapter
        }
    }


    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }

    override fun showPopularMovies(movies: List<MoviesModel.Result>) {
        movieList.addAll(movies)
        movieAdapter.notifyDataSetChanged()
    }

    override fun onAttachView() {
        presenter.onAttach(this)
    }

    override fun onDetachView() {
        presenter.onDetach()

    }
    override fun onSuccessGetPopularMovies() {
        progressBar.gone()
    }
}

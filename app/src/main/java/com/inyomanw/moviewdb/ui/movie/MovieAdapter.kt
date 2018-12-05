package com.inyomanw.moviewdb.ui.movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inyomanw.moviewdb.Constants.Companion.BASE_IMAGE_URL
import com.inyomanw.moviewdb.data.MoviesModel
import com.inyomanw.moviewdb.R
import com.inyomanw.moviewdb.loadImage
import kotlinx.android.synthetic.main.item_row_popular.view.*

class MovieAdapter(val movies: List<MoviesModel.Result>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view : View = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_row_popular,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bindItems(movies[p1])
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bindItems(movie: MoviesModel.Result) = with(itemView){
            img.loadImage(context,"$BASE_IMAGE_URL${movie.poster_path}")
        }

    }
}
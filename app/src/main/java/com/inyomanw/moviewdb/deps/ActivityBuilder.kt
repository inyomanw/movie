package com.inyomanw.moviewdb.deps

import android.annotation.SuppressLint
import com.inyomanw.moviewdb.ui.movie.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@SuppressLint("unused")
@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity
}
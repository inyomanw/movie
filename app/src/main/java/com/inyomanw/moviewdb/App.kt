package com.inyomanw.moviewdb

import android.app.Application
import com.inyomanw.moviewdb.deps.DaggerMovieComponent
import com.inyomanw.moviewdb.deps.NetworkModules
import com.inyomanw.moviewdb.di.dataModule
import com.inyomanw.moviewdb.di.networkModule
import com.inyomanw.moviewdb.di.presenterModule
import com.inyomanw.moviewdb.di.schedulerModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.koin.android.ext.android.startKoin
import timber.log.Timber

//class App : Application() {
//    override fun onCreate() {
//        super.onCreate()
//        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
//        startKoin(this, listOf(networkModule, dataModule, presenterModule, schedulerModule))
//    }
//}

class App : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        val movieComponent = DaggerMovieComponent
            .builder()
            .application(this)
            .NetworkModules(NetworkModules())
            .build()
        movieComponent.inject(this)
        return movieComponent

    }

}
package com.inyomanw.moviewdb.deps

import android.app.Application
import com.inyomanw.moviewdb.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,NetworkModules::class,ActivityBuilder::class))
interface MovieComponent : AndroidInjector<DaggerApplication> {
    fun inject(app : App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun NetworkModules(networkModules: NetworkModules) : Builder
        fun build() : MovieComponent
    }
}
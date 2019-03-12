package br.com.cambit.base

import android.app.Application
import br.com.cambit.base.di.appModule
import br.com.cambit.base.di.dispatcherModule
import br.com.cambit.base.di.remoteRepositoryModule
import br.com.cambit.data.remote.parse.ParseService
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.startKoin

@Suppress("unused")
class App : Application() {

    private val parseService by inject<ParseService>()

    private val modules = listOf(
        appModule,
        remoteRepositoryModule,
        dispatcherModule
    )

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modules)

        parseService.init()
    }
}


package br.com.cambit.base.di

import br.com.cambit.view.screen.itemdetails.ItemDetailsContract
import br.com.cambit.view.screen.itemdetails.ItemDetailsPresenter
import br.com.cambit.view.screen.main.MainContract
import br.com.cambit.view.screen.main.MainPresenter
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module.module

val appModule = module {
    factory { (view: MainContract.View) ->
        MainPresenter(
            view = view,
            repository = get(),
            launcher = get()
        )
    } bind MainContract.Presenter::class

    factory { (view: ItemDetailsContract.View) ->
        ItemDetailsPresenter(
            view = view
        )
    } bind ItemDetailsContract.Presenter::class
}

val dispatcherModule = module {
    single { Dispatchers.Main as CoroutineDispatcher }
}
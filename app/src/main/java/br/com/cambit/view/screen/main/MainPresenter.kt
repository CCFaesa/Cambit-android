package br.com.cambit.view.screen.main

import br.com.cambit.base.extensions.launch
import br.com.cambit.data.model.Item
import br.com.cambit.data.model.whenever
import br.com.cambit.data.remote.cambit.CambitRepository
import kotlinx.coroutines.CoroutineDispatcher

class MainPresenter(
    override var view: MainContract.View,
    private val repository: CambitRepository,
    private val launcher: CoroutineDispatcher
) : MainContract.Presenter {
    override fun loadItems() {
        view.showLoadItemsDialog()

        launcher.launch {
            repository.getItems().whenever(
                isBody = ::onLoadedItems,
                isError = ::onLoadedItemsFailure
            )
        }
    }

    private fun onLoadedItems(items: List<Item>) {
        view.hideLoadItemsDialog()
        view.onLoadedItems(items)
    }

    private fun onLoadedItemsFailure(message: String) {
        view.hideLoadItemsDialog()
        view.showMessageError(message)
    }
}
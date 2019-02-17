package br.com.cambit.view.screen.main

import br.com.cambit.base.BasePresenter
import br.com.cambit.base.BaseView
import br.com.cambit.data.model.Item

interface MainContract {

    interface View : BaseView<Presenter> {
        fun onLoadedItems(items: List<Item>)
        fun showLoadItemsDialog()
        fun hideLoadItemsDialog()
        fun showMessageError(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun loadItems()
    }
}
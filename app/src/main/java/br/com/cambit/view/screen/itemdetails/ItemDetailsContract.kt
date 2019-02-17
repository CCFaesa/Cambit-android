package br.com.cambit.view.screen.itemdetails

import br.com.cambit.base.BasePresenter
import br.com.cambit.base.BaseView

interface ItemDetailsContract {
    interface View : BaseView<Presenter> {
        fun showMessage(message: String)
    }

    interface Presenter : BasePresenter<View> {
        fun test()
    }
}
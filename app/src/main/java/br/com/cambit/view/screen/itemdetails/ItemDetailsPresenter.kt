package br.com.cambit.view.screen.itemdetails

class ItemDetailsPresenter(
    override var view: ItemDetailsContract.View
) : ItemDetailsContract.Presenter {

    override fun test() {
        view.showMessage("test")
    }
}
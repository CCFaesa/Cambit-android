package br.com.cambit.base

interface BaseView<out T : BasePresenter<*>> {
    val presenter: T
}
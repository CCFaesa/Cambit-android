package br.com.cambit.base.di

import br.com.cambit.data.remote.cambit.CambitParseServeRepository
import br.com.cambit.data.remote.cambit.CambitRepository
import br.com.cambit.data.remote.parse.ParseService
import br.com.cambit.data.remote.parse.ParseServiceImpl
import org.koin.dsl.module.module

val remoteRepositoryModule = module {
    factory {
        ParseServiceImpl(get())
    } bind ParseService::class

    factory {
        CambitParseServeRepository()
    } bind CambitRepository::class
}
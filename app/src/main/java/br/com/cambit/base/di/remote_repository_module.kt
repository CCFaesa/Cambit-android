package br.com.cambit.base.di

import br.com.cambit.data.remote.cambit.CambitRepository
import br.com.cambit.data.remote.cambit.CambitRepositoryImpl
import org.koin.dsl.module.module

val remoteRepositoryModule = module {
    factory {
        CambitRepositoryImpl()
    } bind CambitRepository::class
}
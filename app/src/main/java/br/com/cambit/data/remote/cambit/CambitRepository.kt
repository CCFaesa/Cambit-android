package br.com.cambit.data.remote.cambit

import br.com.cambit.data.model.Item
import br.com.cambit.data.model.ServiceResponse

interface CambitRepository {
    suspend fun getItems(): ServiceResponse<List<Item>>
    suspend fun getItems(query: String): ServiceResponse<List<Item>>
}
package br.com.cambit.data.remote.cambit

import br.com.cambit.base.extensions.findObjects
import br.com.cambit.data.model.Item
import br.com.cambit.data.model.ServiceResponse
import br.com.cambit.data.remote.parse.ParseItem

class CambitParseServeRepository : CambitRepository {
    override suspend fun getItems(): ServiceResponse<List<Item>> {
        return ParseItem.findObjects()
    }
}

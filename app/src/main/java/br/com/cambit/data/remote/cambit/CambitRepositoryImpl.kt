package br.com.cambit.data.remote.cambit

import br.com.cambit.data.model.Item
import br.com.cambit.data.model.ServiceResponse
import kotlinx.coroutines.delay

class CambitRepositoryImpl : CambitRepository{

    override suspend fun getItems(): ServiceResponse<List<Item>> {
        delay(2200)
        return ServiceResponse.BODY(
            List(150) {
                val formatedNumber = it.toString().padStart(3, '0')

                Item("Item $formatedNumber", 1180.0, "https://api.adorable.io/avatars/$formatedNumber", "Vitoria - Espirito Santo")
            }
        )
    }
}
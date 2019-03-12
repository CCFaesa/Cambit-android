package br.com.cambit.data.remote.parse

import br.com.cambit.data.model.Item
import com.parse.ParseObject

sealed class ParseTable<T>(val table: String, val converter: (ParseObject) -> T)

object ParseItem : ParseTable<Item>("Item", {
    Item(
        it.getString("name"),
        it.getDouble("price"),
        it.getString("image"),
        it.getString("address")
    )
})
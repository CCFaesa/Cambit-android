package br.com.cambit.data.remote.parse

import br.com.cambit.data.model.Item
import com.parse.ParseObject
import com.parse.ParseQuery

const val TABLE_ITEM = "Item"

const val COLUMN_ITEM_NAME = "name"
const val COLUMN_ITEM_PRICE = "name"
const val COLUMN_ITEM_IMAGE = "name"
const val COLUMN_ITEM_ADDRESS = "name"

sealed class ParseTable<T>(val table: String, val converter: (ParseObject) -> T) {
    val parseObject = ParseQuery<ParseObject>(this.table)
}

object ParseItem : ParseTable<Item>(TABLE_ITEM, {
    Item(
        it.getString(COLUMN_ITEM_NAME),
        it.getDouble(COLUMN_ITEM_PRICE),
        it.getString(COLUMN_ITEM_IMAGE),
        it.getString(COLUMN_ITEM_ADDRESS)
    )
}) {
    fun whereContainsName(parseQuery: ParseQuery<ParseObject>, query: String) {
        parseQuery.whereContains(COLUMN_ITEM_NAME, query)
    }
}
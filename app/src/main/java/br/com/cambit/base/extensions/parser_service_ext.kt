package br.com.cambit.base.extensions

import br.com.cambit.data.model.ServiceResponse
import br.com.cambit.data.remote.parse.ParseTable
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun <T : Any> ParseTable<T>.findObjects(vararg functions:(ParseQuery<ParseObject>) -> Unit): ServiceResponse<List<T>> {
    return suspendCancellableCoroutine { continuation ->
        val query = parseObject

        functions.forEach {
            it(query)
        }

        query.findInBackground { items, e ->
            if (e == null) {
                continuation.resume(ServiceResponse.BODY(items.map { this.converter(it) }))
            } else {
                continuation.resume(ServiceResponse.ERROR(e.message.orEmpty()))
            }
        }
    }
}
package br.com.cambit.base.extensions

import br.com.cambit.data.model.ServiceResponse
import br.com.cambit.data.remote.parse.ParseTable
import com.parse.ParseObject
import com.parse.ParseQuery
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

suspend fun <T : Any> ParseTable<T>.findObjects(): ServiceResponse<List<T>> {
    return suspendCancellableCoroutine { continuation ->
        ParseQuery<ParseObject>(this.table).findInBackground { items, e ->
            if (e == null) {
                continuation.resume(ServiceResponse.BODY(items.map { this.converter(it) }))
            } else {
                continuation.resume(ServiceResponse.ERROR(e.message.orEmpty()))
            }
        }
    }
}
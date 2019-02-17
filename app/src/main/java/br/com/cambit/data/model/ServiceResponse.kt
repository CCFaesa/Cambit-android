package br.com.cambit.data.model

sealed class ServiceResponse<out T : Any> {
    object OK : ServiceResponse<Nothing>()
    class BODY<out T : Any>(val value: T) : ServiceResponse<T>()
    class ERROR(val message: String = "") : ServiceResponse<Nothing>()
}

fun <T : Any, R : Any> ServiceResponse<T>.convert(function: (T) -> R) = when (this) {
    is ServiceResponse.BODY -> ServiceResponse.BODY(function(this.value))
    is ServiceResponse.OK -> this
    is ServiceResponse.ERROR -> this
}

fun <T : Any, R : Any> ServiceResponse<List<T>>.convertList(function: (T) -> R): ServiceResponse<List<R>> {
    return this.convert { it.map(function) }
}

fun <T : Any> ServiceResponse<T>.whenever(
        isBody: (T) -> Unit = {},
        isError: (String) -> Unit = {},
        isOk: () -> Unit = {}
) {
    when (this) {
        is ServiceResponse.BODY<T> -> isBody(this.value)
        is ServiceResponse.ERROR -> isError(this.message)
        is ServiceResponse.OK -> isOk
    }
}
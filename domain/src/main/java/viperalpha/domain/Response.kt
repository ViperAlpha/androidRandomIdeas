package viperalpha.domain

/**
 * Created on 18/03/19
 * @author Reinaldo Moreira da Silva
 * @email rms_master@hotmail.com
 */
data class Response<out T> internal constructor(
    val status: Status,

    val message: String? = null,

    val data: T? = null,

    val error: Throwable? = null
) {

    enum class Status {
        IDLE, LOADING, SUCCESS, ERROR
    }

    companion object {
        fun <T> idle(): Response<T> = Response(Status.IDLE)
        fun <T> loading(): Response<T> = Response(Status.LOADING)
        fun <T> success(data: T? = null, message: String? = null): Response<T> = Response(Status.SUCCESS, message, data)
        fun <T> error(error: Throwable? = null, message: String? = null, data: T? = null): Response<T> =
            Response(Status.ERROR, message ?: "", data, error)

    }

    fun isIdle() = status == Status.IDLE

    fun isLoading() = status == Status.LOADING

    fun isSuccess() = status == Status.SUCCESS

    fun isError() = status == Status.ERROR
}
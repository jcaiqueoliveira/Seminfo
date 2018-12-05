package sample.caique.seminfo.domain

interface Result<T> {

    fun success(info: T)
    fun error(error: Throwable)
}

sealed class Result1 {
    data class Success<T>(val value: T) : Result1()
    data class Error(val value: Throwable) : Result1()

}
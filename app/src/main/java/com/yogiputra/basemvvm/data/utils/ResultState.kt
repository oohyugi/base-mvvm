package com.yogiputra.basemvvm.data.utils

/**
 * Created by oohyugi on 2019-09-18.
 */
sealed class ResultState<out T : Any?> {
    data class Success<out T : Any?>(val data: T?) : ResultState<T>()
    data class Error(val errorMessage: String?) : ResultState<Nothing>()
}
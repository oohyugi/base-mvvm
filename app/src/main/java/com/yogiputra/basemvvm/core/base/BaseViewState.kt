package com.yogiputra.basemvvm.core.base

/**
 * Created by oohyugi on 2019-09-18.
 */
sealed class BaseViewState<out R> {
    object Loading : BaseViewState<Nothing>()
    data class Error(val errorMessage: String?) :
        BaseViewState<Nothing>()

    data class Success<T>(val data: T?) : BaseViewState<T>()
}
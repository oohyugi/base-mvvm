package com.stickearn.stickmartops.core.base

/**
 * Created by oohyugi on 2019-09-18.
 */
sealed class BaseViewState<out R> {
    object ShowLoading : BaseViewState<Nothing>()
    data class ShowError(val errorMessage: String?) :
        BaseViewState<Nothing>()

    data class Success<T>(val data: T?) : BaseViewState<T>()
}
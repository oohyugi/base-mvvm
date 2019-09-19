package com.stickearn.stickmartops.data.utils

import java.net.ConnectException

/**
 * Created by oohyugi on 2019-09-18.
 */
suspend fun <T : Any> fetchState(call: suspend () -> ResultState<T>): ResultState<T> {
    return try {
        call.invoke()
    } catch (e: ConnectException) {
        ResultState.Error(e.message)
    } catch (e: Exception) {
        ResultState.Error(e.message)
    } catch (e: Throwable) {
        ResultState.Error(e.message)

    }
}
package com.stickearn.stickmartops.core.model

/**
 * Created by oohyugi on 2019-09-18.
 */
data class BaseMdl<T>(
    var status: Boolean,
    var http_code: Int? = null,
    var message: String? = "",
    var data: T? = null
)
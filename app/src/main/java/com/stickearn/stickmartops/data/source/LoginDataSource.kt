package com.stickearn.stickmartops.data.source

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import retrofit2.Response

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
interface LoginDataSource {
    suspend fun postLogin(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<ResponseLoginMdl>>

}
package com.stickearn.stickmartops.data.source.remote

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.LoginMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.data.source.LoginDataSource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
class RemoteLoginDataSource @Inject constructor(private val apiService: AuthService) :
    LoginDataSource {
    override suspend fun postLogin(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<LoginMdl>> {
        return apiService.postLogin(requestLoginMdl)
    }

}
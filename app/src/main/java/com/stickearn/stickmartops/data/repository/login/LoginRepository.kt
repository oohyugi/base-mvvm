package com.stickearn.stickmartops.data.repository.login

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import com.stickearn.stickmartops.data.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-18.
 */
interface LoginRepository {
    suspend fun postLogin(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<ResponseLoginMdl>>

    class LoginRepositoryImpl @Inject constructor(private val apiService: ApiService) :
        LoginRepository {
        override suspend fun postLogin(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<ResponseLoginMdl>> {
            return apiService.postLogin(requestLoginMdl)
        }

    }
}
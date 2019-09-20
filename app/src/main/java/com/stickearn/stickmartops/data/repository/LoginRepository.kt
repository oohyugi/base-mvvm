package com.stickearn.stickmartops.data.repository

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.LoginMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.data.source.remote.RemoteLoginDataSource
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.data.utils.fetchState
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-18.
 */
interface LoginRepository {
    suspend fun postLogin(requestLoginMdl: RequestLoginMdl): ResultState<BaseMdl<LoginMdl>>

    class LoginRepositoryImpl @Inject constructor(private val remoteLoginDataSource: RemoteLoginDataSource) :
        LoginRepository {
        override suspend fun postLogin(requestLoginMdl: RequestLoginMdl): ResultState<BaseMdl<LoginMdl>> {
            return fetchState {
                val response = remoteLoginDataSource.postLogin(requestLoginMdl)
                if (response.isSuccessful) {
                    ResultState.Success(response.body())
                } else {
                    ResultState.Error(response.message())
                }
            }
        }


    }
}
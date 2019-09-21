package com.yogiputra.basemvvm.data.repository

import com.yogiputra.basemvvm.core.model.BaseMdl
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import com.yogiputra.basemvvm.data.source.remote.RemoteLoginDataSource
import com.yogiputra.basemvvm.data.utils.ResultState
import com.yogiputra.basemvvm.data.utils.fetchState
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
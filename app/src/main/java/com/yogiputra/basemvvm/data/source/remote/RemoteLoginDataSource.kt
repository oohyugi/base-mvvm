package com.yogiputra.basemvvm.data.source.remote

import com.yogiputra.basemvvm.core.model.BaseMdl
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import com.yogiputra.basemvvm.data.source.LoginDataSource
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
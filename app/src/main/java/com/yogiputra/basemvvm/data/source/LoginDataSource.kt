package com.yogiputra.basemvvm.data.source

import com.yogiputra.basemvvm.core.model.BaseMdl
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import retrofit2.Response

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
interface LoginDataSource {
    suspend fun postLogin(requestLoginMdl: RequestLoginMdl): Response<BaseMdl<LoginMdl>>

}
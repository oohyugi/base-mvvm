package com.yogiputra.basemvvm.data.source.remote

import com.yogiputra.basemvvm.core.model.BaseMdl
import com.yogiputra.basemvvm.core.model.LoginMdl
import com.yogiputra.basemvvm.core.model.RequestLoginMdl
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by oohyugi on 2019-09-18.
 */

interface AuthService {


    @POST("api/v1/auth")
    suspend fun postLogin(@Body payload: RequestLoginMdl): Response<BaseMdl<LoginMdl>>


}
package com.stickearn.stickmartops.data.source.remote

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import com.stickearn.stickmartops.core.model.RequestLoginMdl
import com.stickearn.stickmartops.core.model.ResponseLoginMdl
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by oohyugi on 2019-09-18.
 */

interface BaseService {

    @GET("/home")
    suspend fun getHome(): Response<BaseMdl<List<ExampleMdl>>>

    @POST("api/v1/auth")
    suspend fun postLogin(@Body payload: RequestLoginMdl): Response<BaseMdl<ResponseLoginMdl>>


}
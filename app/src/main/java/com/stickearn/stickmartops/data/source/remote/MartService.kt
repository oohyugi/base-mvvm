package com.stickearn.stickmartops.data.source.remote

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.MartboxMdl
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by oohyugi on 2019-09-18.
 */

interface MartService {

    @GET("mart/box")
    suspend fun getMartboxList(@Query("include") include: String? = null): Response<BaseMdl<List<MartboxMdl>>>


}
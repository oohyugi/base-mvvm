package com.stickearn.stickmartops.data

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import retrofit2.Response

/**
 * Created by oohyugi on 2019-09-18.
 */
interface Repository {

    suspend fun fetchHome(): Response<BaseMdl<List<ExampleMdl>>>
}
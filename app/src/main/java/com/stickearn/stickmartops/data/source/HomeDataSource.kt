package com.stickearn.stickmartops.data.source

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import retrofit2.Response

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
interface HomeDataSource {
    suspend fun fetchHome(): Response<BaseMdl<List<ExampleMdl>>>


}
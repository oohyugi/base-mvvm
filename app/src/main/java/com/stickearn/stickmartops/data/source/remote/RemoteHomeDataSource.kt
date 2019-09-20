package com.stickearn.stickmartops.data.source.remote

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import com.stickearn.stickmartops.data.source.HomeDataSource
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
class RemoteHomeDataSource @Inject constructor(private val apiService: BaseService) :
    HomeDataSource {
    override suspend fun fetchHome(): Response<BaseMdl<List<ExampleMdl>>> {
        return apiService.getHome()
    }

}
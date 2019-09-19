package com.stickearn.stickmartops.data.repository.home

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import com.stickearn.stickmartops.data.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-18.
 */
interface HomeRepository {

    suspend fun fetchHome(): Response<BaseMdl<List<ExampleMdl>>>


    class HomeRepositoryImpl @Inject constructor(private val apiService: ApiService) :
        HomeRepository {

        override suspend fun fetchHome(): Response<BaseMdl<List<ExampleMdl>>> {
            return apiService.getHome()
        }
    }
}
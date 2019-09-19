package com.stickearn.stickmartops.data.source.repository

import com.stickearn.stickmartops.core.model.BaseMdl
import com.stickearn.stickmartops.core.model.ExampleMdl
import com.stickearn.stickmartops.data.source.remote.RemoteHomeDataSource
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.data.utils.fetchState
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-18.
 */
interface HomeRepository {

    suspend fun fetchHome(): ResultState<BaseMdl<List<ExampleMdl>>>


    class HomeRepositoryImpl @Inject constructor(private val remoteHomeDataSource: RemoteHomeDataSource) :
        HomeRepository {
        override suspend fun fetchHome(): ResultState<BaseMdl<List<ExampleMdl>>> {
            return fetchState {
                val response = remoteHomeDataSource.fetchHome()
                if (response.isSuccessful) {
                    ResultState.Success(response.body())
                } else {
                    ResultState.Error(response.message())
                }
            }
        }


    }
}
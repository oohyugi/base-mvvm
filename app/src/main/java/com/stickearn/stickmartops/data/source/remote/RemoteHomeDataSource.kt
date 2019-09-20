package com.stickearn.stickmartops.data.source.remote

import com.stickearn.stickmartops.core.model.MartboxMdl
import com.stickearn.stickmartops.data.source.HomeDataSource
import com.stickearn.stickmartops.data.utils.ResultState
import com.stickearn.stickmartops.data.utils.fetchState
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
class RemoteHomeDataSource @Inject constructor(private val apiService: MartService) :
    HomeDataSource {
    override suspend fun getMartboxList(include: String?): ResultState<List<MartboxMdl>> {

        return fetchState {
            val response = apiService.getMartboxList(include)
            if (response.isSuccessful) {
                ResultState.Success(response.body()?.data)

            } else {
                ResultState.Error(response.message())
            }
        }

    }




}
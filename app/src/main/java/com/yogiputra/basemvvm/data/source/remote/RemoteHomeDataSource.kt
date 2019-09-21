package com.yogiputra.basemvvm.data.source.remote

import com.yogiputra.basemvvm.core.model.MartboxMdl
import com.yogiputra.basemvvm.data.source.HomeDataSource
import com.yogiputra.basemvvm.data.utils.ResultState
import com.yogiputra.basemvvm.data.utils.fetchState
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
package com.stickearn.stickmartops.data.repository

import com.stickearn.stickmartops.core.model.MartboxMdl
import com.stickearn.stickmartops.core.utils.loge
import com.stickearn.stickmartops.data.source.local.LocalMartboxDataSource
import com.stickearn.stickmartops.data.source.local.MartboxDao
import com.stickearn.stickmartops.data.source.remote.RemoteHomeDataSource
import com.stickearn.stickmartops.data.utils.ResultState
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-18.
 */
interface HomeRepository {

    suspend fun fetchHome(
        include: String? = null,
        forceRefresh: Boolean = false
    ): ResultState<List<MartboxMdl>>


    class HomeRepositoryImpl @Inject constructor(
        private val remoteHomeDataSource: RemoteHomeDataSource,
        private val localMartboxDataSource: LocalMartboxDataSource,
        private val db: MartboxDao
    ) :
        HomeRepository {
        override suspend fun fetchHome(
            include: String?,
            forceRefresh: Boolean
        ): ResultState<List<MartboxMdl>> {
            val localData = localMartboxDataSource.getMartboxList(include)
            if (forceRefresh || !checkLocalData(localData)) {
                val remoteData = remoteHomeDataSource.getMartboxList(include)
                saveResponseToLocal(remoteData)
                return remoteData
            }

            return localData


        }

        private fun checkLocalData(localData: ResultState<List<MartboxMdl>>): Boolean {
            var isNotNull = false
            if (localData is ResultState.Success) {
                isNotNull = !localData.data.isNullOrEmpty()
            }
            return isNotNull

        }


        private fun saveResponseToLocal(martboxList: ResultState<List<MartboxMdl>>) {

            when (martboxList) {
                is ResultState.Success -> {

                    martboxList.data?.map {
                        db.insertMartbox(it)
                    }
                }
                is ResultState.Error -> {
                    martboxList.errorMessage?.loge("db error")
                }
            }
        }


    }
}
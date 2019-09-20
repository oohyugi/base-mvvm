package com.stickearn.stickmartops.data.source.local

import com.stickearn.stickmartops.core.model.MartboxMdl
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.source.HomeDataSource
import com.stickearn.stickmartops.data.utils.ResultState
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-20.
 */
class LocalMartboxDataSource @Inject constructor(
    private val dbMartbox: MartboxDao,
    private val dispatcher: AppDispatchers
) : HomeDataSource {
    override suspend fun getMartboxList(include: String?): ResultState<List<MartboxMdl>> =
        withContext(dispatcher.io) {
            return@withContext try {
                ResultState.Success(dbMartbox.getAllMartbox())
            } catch (e: Exception) {
                ResultState.Error(e.localizedMessage)
            }
        }

}
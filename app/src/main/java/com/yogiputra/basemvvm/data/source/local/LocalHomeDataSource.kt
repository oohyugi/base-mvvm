package com.yogiputra.basemvvm.data.source.local

import com.yogiputra.basemvvm.core.model.MartboxMdl
import com.yogiputra.basemvvm.core.utils.AppDispatchers
import com.yogiputra.basemvvm.data.source.HomeDataSource
import com.yogiputra.basemvvm.data.utils.ResultState
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-20.
 */
class LocalHomeDataSource @Inject constructor(
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
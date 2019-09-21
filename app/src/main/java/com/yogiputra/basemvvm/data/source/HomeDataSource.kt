package com.yogiputra.basemvvm.data.source

import com.yogiputra.basemvvm.core.model.MartboxMdl
import com.yogiputra.basemvvm.data.utils.ResultState

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
interface HomeDataSource {
    suspend fun getMartboxList(include: String?): ResultState<List<MartboxMdl>>


}
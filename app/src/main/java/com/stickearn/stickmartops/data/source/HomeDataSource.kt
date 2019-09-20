package com.stickearn.stickmartops.data.source

import com.stickearn.stickmartops.core.model.MartboxMdl
import com.stickearn.stickmartops.data.utils.ResultState

/**
 * Created by oohyugi on 2019-09-19.
 * github: https://github.com/oohyugi
 */
interface HomeDataSource {
    suspend fun getMartboxList(include: String?): ResultState<List<MartboxMdl>>


}
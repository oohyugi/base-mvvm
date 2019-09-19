package com.stickearn.stickmartops.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by oohyugi on 2019-09-18.
 */
class AppDispatchers @Inject constructor(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
)
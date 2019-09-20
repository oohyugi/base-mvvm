package com.stickearn.stickmartops.core.di

import android.content.Context
import com.stickearn.stickmartops.core.helper.PrefHelper
import com.stickearn.stickmartops.core.utils.AppDispatchers
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers


/**
 * Created by oohyugi on 2019-09-19.
 */

@Module
class CoreModule(private val context: Context) {

    @Provides
    fun providesContext(): Context {
        return context
    }


    @Provides
    fun provideAppDispatcher(): AppDispatchers = AppDispatchers(Dispatchers.Main, Dispatchers.IO)

    @Provides
    fun providePrefHelper(context: Context): PrefHelper {
        return PrefHelper(context)
    }


}
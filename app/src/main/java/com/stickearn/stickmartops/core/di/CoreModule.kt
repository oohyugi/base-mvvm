package com.stickearn.stickmartops.core.di

import android.content.Context
import com.stickearn.stickmartops.core.helper.PrefHelper
import dagger.Module
import dagger.Provides


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
    fun providePrefHelper(context: Context): PrefHelper {
        return PrefHelper(context)
    }

}
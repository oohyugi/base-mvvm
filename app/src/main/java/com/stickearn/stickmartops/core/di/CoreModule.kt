package com.stickearn.stickmartops.core.di

import android.content.Context
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


}
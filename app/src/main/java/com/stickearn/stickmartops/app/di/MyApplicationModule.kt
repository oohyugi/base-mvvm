package com.stickearn.stickmartops.app.di

import android.app.Application
import com.stickearn.stickmartops.app.MyApplication
import dagger.Module
import dagger.Provides


/**
 * Created by oohyugi on 2019-09-19.
 */
@Module
internal class AppModule(private val application: MyApplication) {

    @Provides
    fun provideApplication(): Application {
        return application
    }

}
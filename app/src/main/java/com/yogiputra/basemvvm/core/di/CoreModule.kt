package com.yogiputra.basemvvm.core.di

import android.content.Context
import androidx.room.Room
import com.yogiputra.basemvvm.core.helper.PrefHelper
import com.yogiputra.basemvvm.core.utils.AppDispatchers
import com.yogiputra.basemvvm.data.source.local.AppDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


/**
 * Created by oohyugi on 2019-09-19.
 */

@Module
class CoreModule(private val application: Context) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return application
    }


    @Provides
    fun provideAppDispatcher(): AppDispatchers = AppDispatchers(Dispatchers.Main, Dispatchers.IO)

    @Provides
    fun providePrefHelper(context: Context): PrefHelper {
        return PrefHelper(context)
    }


    @Provides
    @Singleton
    fun provideAppDatabase(application: Context): AppDatabase {

        return Room.databaseBuilder(
            application,
            AppDatabase::class.java, AppDatabase.DATABASE_NAME
        )
            .build()

    }

}
package com.stickearn.stickmartops.data.di

import com.stickearn.stickmartops.BuildConfig
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.source.HomeDataSource
import com.stickearn.stickmartops.data.source.LoginDataSource
import com.stickearn.stickmartops.data.source.local.AppDatabase
import com.stickearn.stickmartops.data.source.local.LocalMartboxDataSource
import com.stickearn.stickmartops.data.source.local.MartboxDao
import com.stickearn.stickmartops.data.source.remote.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by oohyugi on 2019-09-18.
 */
@Module
class DataModule {


//    @Singleton

    //    @Singleton
    @Provides
    @Singleton
    fun provideMartboxDao(appDatabase: AppDatabase): MartboxDao {
        return appDatabase.martboxDao()
    }

    @Provides
    fun provideServiceBase(): MartService {
        return ApiClient.retrofitClient(BuildConfig.API_URL).create(MartService::class.java)
    }

    @Provides
    fun provideServiceAuth(): AuthService {
        return ApiClient.retrofitClient(BuildConfig.AUTH_URL).create(AuthService::class.java)
    }


    @Provides
    fun provideRemoteLoginDataSource(apiServiceAuth: AuthService): LoginDataSource {
        return RemoteLoginDataSource(apiServiceAuth)
    }


    @Provides
    fun provideRemoteHomeDataSource(apiServiceMart: MartService): HomeDataSource {
        return RemoteHomeDataSource(apiServiceMart)
    }

    @Provides
    fun provideLocalHomeDataSource(
        dbMartbox: MartboxDao,
        appDispatchers: AppDispatchers
    ): HomeDataSource {
        return LocalMartboxDataSource(dbMartbox, appDispatchers)
    }


}
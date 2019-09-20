package com.stickearn.stickmartops.data.di

import com.stickearn.stickmartops.BuildConfig
import com.stickearn.stickmartops.data.source.HomeDataSource
import com.stickearn.stickmartops.data.source.LoginDataSource
import com.stickearn.stickmartops.data.source.remote.*
import dagger.Module
import dagger.Provides

/**
 * Created by oohyugi on 2019-09-18.
 */
@Module
class DataModule {


    @Provides
    fun provideServiceBase(): BaseService {
        return ApiClient.retrofitClient(BuildConfig.BASE_URL).create(BaseService::class.java)
    }

    @Provides
    fun provideServiceAuth(): AuthService {
        return ApiClient.retrofitClient(BuildConfig.AUTH_URL).create(AuthService::class.java)
    }

    @JvmSuppressWildcards
    @Provides
    fun provideRemoteLoginDataSource(apiServiceAuth: AuthService): LoginDataSource {
        return RemoteLoginDataSource(apiServiceAuth)
    }

    @JvmSuppressWildcards
    @Provides
    fun provideRemoteHomeDataSource(apiServiceBase: BaseService): HomeDataSource {
        return RemoteHomeDataSource(apiServiceBase)
    }
}
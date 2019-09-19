package com.stickearn.stickmartops.data.di

import com.stickearn.stickmartops.BuildConfig
import com.stickearn.stickmartops.data.remote.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by oohyugi on 2019-09-18.
 */
@Module
class DataModule {


    @Provides
    @Named("serviceAuth")
    fun provideServiceAuth(): ApiService {
        return ApiService.retrofitClient(BuildConfig.AUTH_URL).create(ApiService::class.java)
    }


    @Provides
    fun provideService(): ApiService {
        return ApiService.retrofitClient(BuildConfig.BASE_URL).create(ApiService::class.java)
    }
}
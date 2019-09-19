package com.stickearn.stickmartops.feature.home.di

import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.di.DataModule
import com.stickearn.stickmartops.data.source.remote.RemoteHomeDataSource
import com.stickearn.stickmartops.data.source.repository.HomeRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

/**
 * Created by oohyugi on 2019-09-18.
 */
@Module(includes = [DataModule::class, CoreModule::class])
class HomeModule {


    @HomeScope
    @Provides
    fun provideHomeRepository(remoteHomeDataSource: RemoteHomeDataSource): HomeRepository {
        return HomeRepository.HomeRepositoryImpl(remoteHomeDataSource)
    }

    @HomeScope
    @Provides
    fun provideAppDispatcher(): AppDispatchers = AppDispatchers(Dispatchers.Main, Dispatchers.IO)

}
package com.stickearn.stickmartops.feature.home.di

import com.stickearn.stickmartops.data.repository.HomeRepository
import com.stickearn.stickmartops.data.source.local.LocalMartboxDataSource
import com.stickearn.stickmartops.data.source.local.MartboxDao
import com.stickearn.stickmartops.data.source.remote.RemoteHomeDataSource
import dagger.Module
import dagger.Provides

/**
 * Created by oohyugi on 2019-09-18.
 */
@Module
class HomeModule {


    @Provides
    fun provideHomeRepository(
        remoteHomeDataSource: RemoteHomeDataSource,
        localMartboxDataSource: LocalMartboxDataSource,
        dbMartbox: MartboxDao
    ): HomeRepository {
        return HomeRepository.HomeRepositoryImpl(
            remoteHomeDataSource,
            localMartboxDataSource,
            dbMartbox
        )
    }


}
package com.yogiputra.basemvvm.feature.home.di

import com.yogiputra.basemvvm.data.repository.HomeRepository
import com.yogiputra.basemvvm.data.source.local.LocalHomeDataSource
import com.yogiputra.basemvvm.data.source.local.MartboxDao
import com.yogiputra.basemvvm.data.source.remote.RemoteHomeDataSource
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
        localHomeDataSource: LocalHomeDataSource,
        dbMartbox: MartboxDao
    ): HomeRepository {
        return HomeRepository.HomeRepositoryImpl(
            remoteHomeDataSource,
            localHomeDataSource,
            dbMartbox
        )
    }


}
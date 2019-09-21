package com.yogiputra.basemvvm.feature.login.di

import com.yogiputra.basemvvm.data.repository.LoginRepository
import com.yogiputra.basemvvm.data.source.remote.RemoteLoginDataSource
import dagger.Module
import dagger.Provides

@Module
class LoginModule {


    @Provides
    fun provideLoginRepository(remoteLoginDataSource: RemoteLoginDataSource): LoginRepository {
        return LoginRepository.LoginRepositoryImpl(remoteLoginDataSource)
    }


}
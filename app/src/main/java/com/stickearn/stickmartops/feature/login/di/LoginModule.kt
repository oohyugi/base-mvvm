package com.stickearn.stickmartops.feature.login.di

import com.stickearn.stickmartops.data.repository.LoginRepository
import com.stickearn.stickmartops.data.source.remote.RemoteLoginDataSource
import dagger.Module
import dagger.Provides

@Module
class LoginModule {


    @Provides
    fun provideLoginRepository(remoteLoginDataSource: RemoteLoginDataSource): LoginRepository {
        return LoginRepository.LoginRepositoryImpl(remoteLoginDataSource)
    }


}
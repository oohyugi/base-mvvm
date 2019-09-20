package com.stickearn.stickmartops.feature.login.di

import android.content.Context
import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.core.helper.PrefHelper
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.di.DataModule
import com.stickearn.stickmartops.data.source.remote.RemoteLoginDataSource
import com.stickearn.stickmartops.data.source.repository.LoginRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

@Module(includes = [DataModule::class, CoreModule::class])
class LoginModule {

    @LoginScope
    @Provides
    fun provideLoginRepository(remoteLoginDataSource: RemoteLoginDataSource): LoginRepository {
        return LoginRepository.LoginRepositoryImpl(remoteLoginDataSource)
    }


}
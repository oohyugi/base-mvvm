package com.stickearn.stickmartops.feature.home.di

import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.di.DataModule
import com.stickearn.stickmartops.data.remote.ApiService
import com.stickearn.stickmartops.data.repository.login.LoginRepository
import com.stickearn.stickmartops.feature.home.domain.HomeUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

/**
 * Created by oohyugi on 2019-09-18.
 */
@Module(includes = [DataModule::class])
class HomeModule {

    @HomeScope
    @Provides
    fun provideHomeRepository(apiServiceBase: ApiService): LoginRepository {
        return LoginRepository.LoginRepositoryImpl(apiServiceBase)
    }

    //
    @HomeScope
    @Provides
    fun provideHomeUseCase(repositoryImpl: LoginRepository): HomeUseCase {
        return HomeUseCase(repositoryImpl)
    }

    //
    @HomeScope
    @Provides
    fun provideAppDispatcher(): AppDispatchers = AppDispatchers(Dispatchers.Main, Dispatchers.IO)

}
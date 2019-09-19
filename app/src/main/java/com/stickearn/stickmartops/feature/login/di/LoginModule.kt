package com.stickearn.stickmartops.feature.login.di

import android.content.Context
import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.core.helper.PrefHelper
import com.stickearn.stickmartops.core.utils.AppDispatchers
import com.stickearn.stickmartops.data.di.DataModule
import com.stickearn.stickmartops.data.remote.ApiService
import com.stickearn.stickmartops.data.repository.login.LoginRepository
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Named

@Module(includes = [DataModule::class, CoreModule::class])
class LoginModule {

    @LoginScope
    @Provides
    fun provideLoginRepository(@Named("serviceAuth") apiServiceAuth: ApiService): LoginRepository {
        return LoginRepository.LoginRepositoryImpl(apiServiceAuth)
    }

    @LoginScope
    @Provides
    fun provideAppDispatcher(): AppDispatchers = AppDispatchers(Dispatchers.Main, Dispatchers.IO)


    @LoginScope
    @Provides
    fun providePrefHelper(context: Context): PrefHelper {
        return PrefHelper(context)
    }

}
package com.stickearn.stickmartops.feature.login.di

import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.data.di.DataModule
import com.stickearn.stickmartops.feature.login.ui.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        LoginModule::class,
        LoginViewModelModule::class,
        CoreModule::class,
        DataModule::class
    ]
)
interface LoginComponent {
    fun inject(activity: LoginActivity)
}

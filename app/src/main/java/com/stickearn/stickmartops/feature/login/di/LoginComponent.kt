package com.stickearn.stickmartops.feature.login.di

import com.stickearn.stickmartops.feature.login.ui.LoginActivity
import dagger.Component

@LoginScope
@Component(
    modules = [
        LoginModule::class,
        LoginViewModelModule::class
    ]
)
interface LoginComponent {
    fun inject(activity: LoginActivity)
}

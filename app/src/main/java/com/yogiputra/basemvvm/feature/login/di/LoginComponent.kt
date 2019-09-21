package com.yogiputra.basemvvm.feature.login.di

import com.yogiputra.basemvvm.core.di.CoreModule
import com.yogiputra.basemvvm.data.di.DataModule
import com.yogiputra.basemvvm.feature.login.ui.LoginActivity
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

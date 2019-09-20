package com.stickearn.stickmartops.feature.login.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stickearn.stickmartops.core.base.BaseViewModelFactory
import com.stickearn.stickmartops.core.base.ViewModelKey
import com.stickearn.stickmartops.feature.login.ui.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginViewModelModule {


    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    internal abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel
}
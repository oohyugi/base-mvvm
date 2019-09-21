package com.yogiputra.basemvvm.feature.login.di


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yogiputra.basemvvm.core.base.BaseViewModelFactory
import com.yogiputra.basemvvm.core.base.ViewModelKey
import com.yogiputra.basemvvm.feature.login.ui.LoginViewModel
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
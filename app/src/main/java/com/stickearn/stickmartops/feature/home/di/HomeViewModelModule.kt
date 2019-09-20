package com.stickearn.stickmartops.feature.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stickearn.stickmartops.core.base.BaseViewModelFactory
import com.stickearn.stickmartops.core.base.ViewModelKey
import com.stickearn.stickmartops.feature.home.ui.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by oohyugi on 2019-09-18.
 */

@Module
abstract class HomeViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

}
package com.yogiputra.basemvvm.feature.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yogiputra.basemvvm.core.base.BaseViewModelFactory
import com.yogiputra.basemvvm.core.base.ViewModelKey
import com.yogiputra.basemvvm.feature.home.ui.HomeViewModel
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
package com.yogiputra.basemvvm.feature.home.di

import com.yogiputra.basemvvm.core.di.CoreModule
import com.yogiputra.basemvvm.data.di.DataModule
import com.yogiputra.basemvvm.feature.home.ui.HomeFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by oohyugi on 2019-09-18.
 */
@Singleton
@Component(
    modules = [
        HomeModule::class,
        HomeViewModelModule::class,
        CoreModule::class,
        DataModule::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
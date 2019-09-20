package com.stickearn.stickmartops.feature.home.di

import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.data.di.DataModule
import com.stickearn.stickmartops.feature.home.ui.HomeFragment
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
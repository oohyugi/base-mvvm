package com.stickearn.stickmartops.feature.home.di

import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.feature.home.ui.HomeFragment
import dagger.Component

/**
 * Created by oohyugi on 2019-09-18.
 */
@HomeScope
@Component(
    modules = [
        HomeModule::class,
        HomeViewModelModule::class,
        CoreModule::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
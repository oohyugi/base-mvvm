package com.stickearn.stickmartops.feature.home.di

import com.stickearn.stickmartops.feature.home.ui.HomeFragment
import dagger.Component

/**
 * Created by oohyugi on 2019-09-18.
 */
@HomeScope
@Component(
    modules = [
        HomeModule::class,
        HomeViewModelModule::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
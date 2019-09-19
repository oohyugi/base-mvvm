package com.stickearn.stickmartops.feature.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.stickearn.stickmartops.R
import com.stickearn.stickmartops.core.base.BaseFragment
import com.stickearn.stickmartops.feature.home.di.DaggerHomeComponent
import com.stickearn.stickmartops.feature.home.di.HomeModule
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectDI()


        initObserve()
    }

    private fun initObserve() {
        mViewModel.apply {

        }
    }


    private fun injectDI() {
        DaggerHomeComponent.builder().homeModule(HomeModule()).build().inject(this)
    }

}

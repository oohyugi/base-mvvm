package com.yogiputra.basemvvm.feature.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.yogiputra.basemvvm.R
import com.yogiputra.basemvvm.core.base.BaseFragment
import com.yogiputra.basemvvm.core.base.BaseViewState
import com.yogiputra.basemvvm.core.di.CoreModule
import com.yogiputra.basemvvm.core.helper.PrefHelper
import com.yogiputra.basemvvm.core.utils.loge
import com.yogiputra.basemvvm.feature.home.di.DaggerHomeComponent
import com.yogiputra.basemvvm.feature.home.di.HomeModule
import javax.inject.Inject

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var prefHelper: PrefHelper
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

        Gson().toJson(prefHelper.getUserLogin()).loge("User Data")
        initObserve()
    }

    private fun initObserve() {
        mViewModel.apply {
            mMbarboxList.observe(this@HomeFragment, Observer {
                when (it) {
                    is BaseViewState.Success -> {
                        Gson().toJson(it).loge("martbox")
                    }
                    is BaseViewState.Error -> {
                        it.errorMessage?.loge("martbox")

                    }
                }

            })
        }
    }


    private fun injectDI() {
        DaggerHomeComponent.builder().homeModule(HomeModule()).coreModule(CoreModule(context!!))
            .build().inject(this)
    }

}

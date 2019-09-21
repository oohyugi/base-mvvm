package com.yogiputra.basemvvm.feature.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yogiputra.basemvvm.R
import com.yogiputra.basemvvm.core.base.BaseActivity
import com.yogiputra.basemvvm.core.base.BaseViewState
import com.yogiputra.basemvvm.core.di.CoreModule
import com.yogiputra.basemvvm.core.helper.PrefHelper
import com.yogiputra.basemvvm.core.utils.toast
import com.yogiputra.basemvvm.feature.MainActivity
import com.yogiputra.basemvvm.feature.login.di.DaggerLoginComponent
import com.yogiputra.basemvvm.feature.login.di.LoginModule
import kotlinx.android.synthetic.main.activity_login_layout.*
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)

            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var prefHelper: PrefHelper
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login_layout)

        injectDI()

        btnLogin?.setOnClickListener {
            mViewModel.login("admin@stickmart.store", "Stickmart2018")
        }

        initObserve()

    }

    private fun injectDI() {
        DaggerLoginComponent.builder().loginModule(LoginModule())
            .coreModule(CoreModule(applicationContext)).build().inject(this)

    }

    private fun initObserve() {
        mViewModel.apply {

            responseLogin.observe(this@LoginActivity, Observer {
                when (it) {
                    is BaseViewState.Success -> {

                        prefHelper.saveUserLogin(it.data)
                        this@LoginActivity.toast("Success")
                        MainActivity.startThisActivity(this@LoginActivity)
                    }
                    is BaseViewState.Error -> this@LoginActivity.toast(it.errorMessage)
                }
            })
        }
    }


}

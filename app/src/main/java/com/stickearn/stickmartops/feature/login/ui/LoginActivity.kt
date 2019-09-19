package com.stickearn.stickmartops.feature.login.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.stickearn.stickmartops.R
import com.stickearn.stickmartops.core.base.BaseActivity
import com.stickearn.stickmartops.core.base.BaseViewState
import com.stickearn.stickmartops.core.di.CoreModule
import com.stickearn.stickmartops.core.helper.PrefHelper
import com.stickearn.stickmartops.core.utils.toast
import com.stickearn.stickmartops.feature.MainActivity
import com.stickearn.stickmartops.feature.login.di.DaggerLoginComponent
import com.stickearn.stickmartops.feature.login.di.LoginModule
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
                    is BaseViewState.ShowError -> this@LoginActivity.toast(it.errorMessage)
                }
            })
        }
    }


}

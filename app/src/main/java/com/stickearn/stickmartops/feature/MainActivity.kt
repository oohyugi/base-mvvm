package com.stickearn.stickmartops.feature

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.stickearn.stickmartops.R
import com.stickearn.stickmartops.core.utils.replaceFragment
import com.stickearn.stickmartops.feature.home.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)

            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            this.replaceFragment(HomeFragment.newInstance(), R.id.container, "")
        }
    }
}

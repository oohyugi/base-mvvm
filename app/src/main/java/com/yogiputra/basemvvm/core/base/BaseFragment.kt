package com.yogiputra.basemvvm.core.base

import android.content.Context
import androidx.fragment.app.Fragment

/**
 * Created by oohyugi on 2019-09-18.
 */
abstract class BaseFragment : Fragment() {


    lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


}
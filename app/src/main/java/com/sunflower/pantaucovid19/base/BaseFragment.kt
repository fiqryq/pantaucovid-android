package com.sunflower.pantaucovid19.base

import android.os.Bundle
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.frogobox.sdk.view.FrogoFragment

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Pantau-Covid19
 * Copyright (C) 04/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.sunflower.pantaucovid19
 */

abstract class BaseFragment<VB : ViewBinding> : FrogoFragment<VB>() {

    protected var mActivity: BaseActivity<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = activity as BaseActivity<*>?
    }

    protected fun showToastShort(message: String?) {
        mActivity!!.showToastShort(message)
    }

    protected fun showToastLong(message: String?) {
        mActivity!!.showToastLong(message)
    }

    protected fun setupFragment(fragment: Fragment?, layout: Int) {
        childFragmentManager
            .beginTransaction()
            .replace(layout, fragment!!)
            .commit()
    }

    protected fun showingProgress(progressBar: ProgressBar?) {
        mActivity!!.showingProgress(progressBar!!)
    }

    protected fun hidingProgress(progressBar: ProgressBar?) {
        mActivity!!.hidingProgress(progressBar!!)
    }

}
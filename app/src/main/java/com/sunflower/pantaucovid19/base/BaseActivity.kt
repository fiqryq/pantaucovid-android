package com.sunflower.pantaucovid19.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.frogobox.sdk.view.FrogoActivity

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
abstract class BaseActivity<VB : ViewBinding> : FrogoActivity<VB>() {

    protected var mActivity: AppCompatActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this
    }

    fun showToastShort(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun showToastLong(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    protected fun setupFragment(fragment: Fragment?, layout: Int) {
        supportFragmentManager
            .beginTransaction()
            .replace(layout, fragment!!)
            .commit()
    }

    fun showingProgress(progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
    }

    fun hidingProgress(progressBar: ProgressBar) {
        progressBar.visibility = View.GONE
    }

}
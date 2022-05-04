/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 * Picked up from animize project,an Anime Streaming Service
 */

package com.sunflower.pantaucovid19.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sunflower.pantaucovid19.base.BaseActivity
import com.sunflower.pantaucovid19.databinding.ActivityWebviewBinding

class WebViewActivity : BaseActivity<ActivityWebviewBinding>() {

    private var newsURL = ""

    override fun setupViewBinding(): ActivityWebviewBinding {
        return ActivityWebviewBinding.inflate(layoutInflater)
    }

    override fun setupOnCreate(savedInstanceState: Bundle?) {

        val intent = intent
        if (intent.getStringExtra("url") != null) {
            newsURL = intent.getStringExtra("url")!!
            //intent.removeExtra("id_anim");
        }

        binding.actWebView.apply {
            settings.apply {
                domStorageEnabled = true
                javaScriptEnabled = true
                loadWithOverviewMode = true
                useWideViewPort = true

            }
            setLayerType(View.LAYER_TYPE_HARDWARE, null)
            webViewClient = object : WebViewClient() {

                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    Log.i("URL FINISH:", url)
                }
            }
            loadUrl(newsURL)
        }

    }

}
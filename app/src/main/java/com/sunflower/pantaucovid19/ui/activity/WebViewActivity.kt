/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 * Picked up from animize project,an Anime Streaming Service
 */

package com.sunflower.pantaucovid19.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.sunflower.pantaucovid19.R
import com.sunflower.pantaucovid19.base.BaseActivity

class WebViewActivity : BaseActivity() {
    var newsURL = ""
    private var webView: WebView? = null
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        initialize()
        val intent = intent
        if (intent.getStringExtra("url") != null) {
            newsURL = intent.getStringExtra("url")!!
            //intent.removeExtra("id_anim");
        }
        webView?.settings?.domStorageEnabled=true
        webView?.settings?.javaScriptEnabled = true
        webView?.settings?.loadWithOverviewMode = true
        webView?.settings?.useWideViewPort = true
        webView?.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        webView?.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                Log.i("URL FINISH:", url)
            }
        }
        webView?.loadUrl(newsURL)
    }

    private fun initialize(){
        webView = findViewById(R.id.actWebView)
    }
}
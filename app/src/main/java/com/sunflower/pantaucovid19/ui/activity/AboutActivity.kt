/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 */


package com.sunflower.pantaucovid19.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sunflower.pantaucovid19.R
import com.sunflower.pantaucovid19.base.BaseActivity
import com.sunflower.pantaucovid19.source.model.Contributors
import com.sunflower.pantaucovid19.ui.adapter.AboutAdapter
import com.sunflower.pantaucovid19.utils.ReadAssetJSON
import org.json.JSONException
import org.json.JSONObject

class AboutActivity : BaseActivity() {
    var listContributor: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        listContributor = findViewById(R.id.infoContributorList)
        getProfileData()
    }

    private fun getProfileData() {
        val jsonData = ReadAssetJSON().getJsonAssets(this, "author.json")
        val data = ArrayList<Contributors>()
        try {
            val jsoobj = JSONObject(jsonData!!).getJSONArray("data")
            for (i in 0 until jsoobj.length()) {
                val x = jsoobj.getJSONObject(i)
                val name = x.getString("contributor_name")
                val github = x.getString("github")
                val pict = x.getString("pict_url")
                data.add(Contributors(name, github, pict))
            }
            val adapter = AboutAdapter(data)
            val linearLayoutManager = LinearLayoutManager(this)
            listContributor!!.layoutManager = linearLayoutManager
            listContributor!!.adapter = adapter


        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}
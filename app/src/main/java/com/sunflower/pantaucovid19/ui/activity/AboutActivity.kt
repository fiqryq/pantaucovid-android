/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 */


package com.sunflower.pantaucovid19.ui.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoBindingAdapter
import com.frogobox.recycler.ext.injectorBinding
import com.frogobox.sdk.ext.glideLoad
import com.sunflower.pantaucovid19.base.BaseActivity
import com.sunflower.pantaucovid19.databinding.ActivityAboutBinding
import com.sunflower.pantaucovid19.databinding.ListContributorBinding
import com.sunflower.pantaucovid19.source.model.Contributors
import com.sunflower.pantaucovid19.utils.FuncHelper
import com.sunflower.pantaucovid19.utils.ReadAssetJSON
import org.json.JSONException
import org.json.JSONObject

class AboutActivity : BaseActivity<ActivityAboutBinding>() {

    override fun setupViewBinding(): ActivityAboutBinding {
        return ActivityAboutBinding.inflate(layoutInflater)
    }

    override fun setupOnCreate(savedInstanceState: Bundle?) {
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

            binding.infoContributorList.injectorBinding<Contributors, ListContributorBinding>()
                .addData(data)
                .addCallback(object : IFrogoBindingAdapter<Contributors, ListContributorBinding> {
                    override fun onItemClicked(
                        binding: ListContributorBinding,
                        data: Contributors,
                        position: Int,
                        notifyListener: FrogoRecyclerNotifyListener<Contributors>
                    ) {
                        val i = Intent(Intent.ACTION_VIEW)
                        val url = FuncHelper.Func.getGithubUrl(data.githubURL)
                        i.data = Uri.parse(url)
                        println(url)
                        startActivity(i)
                    }

                    override fun onItemLongClicked(
                        binding: ListContributorBinding,
                        data: Contributors,
                        position: Int,
                        notifyListener: FrogoRecyclerNotifyListener<Contributors>
                    ) {
                    }

                    override fun setViewBinding(parent: ViewGroup): ListContributorBinding {
                        return ListContributorBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    }

                    override fun setupInitComponent(
                        binding: ListContributorBinding,
                        data: Contributors,
                        position: Int,
                        notifyListener: FrogoRecyclerNotifyListener<Contributors>
                    ) {
                        binding.apply {
                            listInfoName.text = data.name
                            listInfoGithub.text = data.githubURL
                            listInfoImage.glideLoad(data.picURL)
                        }
                    }
                })
                .createLayoutLinearVertical(false)
                .build()


        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }


}
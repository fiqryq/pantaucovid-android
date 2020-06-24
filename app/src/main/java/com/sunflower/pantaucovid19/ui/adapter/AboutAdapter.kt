/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 */

package com.sunflower.pantaucovid19.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sunflower.pantaucovid19.R
import com.sunflower.pantaucovid19.source.model.Contributors
import com.sunflower.pantaucovid19.utils.FuncHelper.Func.getGithubUrl
import kotlinx.android.synthetic.main.list_contributor.view.*


class AboutAdapter(contribList: ArrayList<Contributors>) : RecyclerView.Adapter<AboutAdapter.ViewHolder>() {
    val conList = contribList
    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context
        val view = inflater.inflate(R.layout.list_contributor, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return conList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.github.text = conList[position].githubURL
        holder.name.text = conList[position].name
        Glide.with(context!!).load(conList[position].picURL).into(holder.image)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lays = itemView.listInfoLayout
        val name = itemView.listInfoName
        val github = itemView.listInfoGithub
        val image = itemView.listInfoImage

        init {
            lays.setOnClickListener {
                val i = Intent(Intent.ACTION_VIEW)
                val url = getGithubUrl(conList[adapterPosition].githubURL)
                i.data = Uri.parse(url)
                println(url)
                context!!.startActivity(i)
            }
        }

    }
}
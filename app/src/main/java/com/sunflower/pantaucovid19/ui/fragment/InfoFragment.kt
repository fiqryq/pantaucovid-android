package com.sunflower.pantaucovid19.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunflower.pantaucovid19.base.BaseFragment
import com.sunflower.pantaucovid19.databinding.FragmentInfoBinding
import com.sunflower.pantaucovid19.ui.activity.AboutActivity
import com.sunflower.pantaucovid19.ui.activity.EmergencyNumberActivity
import com.sunflower.pantaucovid19.ui.activity.RumahSakitRujukanActivity

/**
 * A simple [Fragment] subclass.
 */
class InfoFragment : BaseFragment<FragmentInfoBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentInfoBinding {
        return FragmentInfoBinding.inflate(inflater, container, false)
    }

    override fun setupOnViewCreated(view: View, bundle: Bundle?) {
        binding.apply {
            aboutSelect.setOnClickListener { frogoStartActivity<AboutActivity>() }
            CallSelect.setOnClickListener { frogoStartActivity<EmergencyNumberActivity>() }
            RumahSakit.setOnClickListener { frogoStartActivity<RumahSakitRujukanActivity>() }
        }
    }

}
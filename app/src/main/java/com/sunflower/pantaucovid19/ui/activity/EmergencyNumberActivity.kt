package com.sunflower.pantaucovid19.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.sunflower.pantaucovid19.base.BaseActivity
import com.sunflower.pantaucovid19.databinding.ActivityEmergencyNumberBinding

class EmergencyNumberActivity : BaseActivity<ActivityEmergencyNumberBinding>() {

    private val NUMBER_CALL = "119";
    private val REQUEST_PHONE_CALL = 1

    override fun setupViewBinding(): ActivityEmergencyNumberBinding {
        return ActivityEmergencyNumberBinding.inflate(layoutInflater)
    }

    override fun setupOnCreate(savedInstanceState: Bundle?) {
        binding.cdCall.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.CALL_PHONE),
                    REQUEST_PHONE_CALL
                )
            } else {
                startCall();
            }

        }
    }

    @SuppressLint("MissingPermission")
    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)

        callIntent.data = Uri.parse("tel:" + NUMBER_CALL)

        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PHONE_CALL) startCall()
    }

}

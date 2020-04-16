package com.sunflower.pantaucovid19.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.sunflower.pantaucovid19.R
import com.sunflower.pantaucovid19.base.BaseActivity
import kotlinx.android.synthetic.main.activity_emergency_number.*

class EmergencyNumberActivity : BaseActivity() {

    val numberCall = "119";
    val REQUEST_PHONE_CALL = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency_number)
        cd_call.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), REQUEST_PHONE_CALL)
            } else {
                startCall();
            }

        }
    }

    @SuppressLint("MissingPermission")
    private fun startCall() {
        val callIntent = Intent(Intent.ACTION_CALL)

        callIntent.data = Uri.parse("tel:" + numberCall)

        startActivity(callIntent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_PHONE_CALL) startCall()
    }
}

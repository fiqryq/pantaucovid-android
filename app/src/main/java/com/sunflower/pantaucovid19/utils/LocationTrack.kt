/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 */

package com.sunflower.pantaucovid19.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Context.LOCATION_SERVICE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import com.sunflower.pantaucovid19.MainActivity


class LocationTrack(context : Context) : LocationListener {

    var mContext = context
    var checkGPS = false


    var checkNetwork = false

    var canGetLocation = false

    var loc: Location? = null
    var latitude = 0.0
    var longitude = 0.0


    private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 10


    private val MIN_TIME_BW_UPDATES = 1000 * 60 * 1.toLong()
    var locationManager: LocationManager? = null

    var permissions = ArrayList<String>()
    var permissionsToRequest = ArrayList<String>()
    var perms : Permissions? = null
    init {
        perms = Permissions(mContext)
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

        permissionsToRequest = perms!!.permissionsToRequest(permissions)!!

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size > 0) {
                requestPermissions((mContext as MainActivity),permissionsToRequest
                        .toArray(arrayOfNulls(permissionsToRequest.size)), ALL_PERMISSIONS_RESULT)
            }
        }else{
            showSettingsAlert()
        }
        val loca = getLocation()
        if(loca != null){
            longitude = loca.longitude
            latitude = loca.latitude
        }
    }

    fun getLocation(): Location? {
        try {
            locationManager = (mContext as MainActivity)
                    .getSystemService(LOCATION_SERVICE) as LocationManager?
            // get GPS status
            checkGPS = locationManager!!
                    .isProviderEnabled(LocationManager.GPS_PROVIDER)
            // get network provider status
            checkNetwork = locationManager!!
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            if (!checkGPS && !checkNetwork) {
                Toast.makeText(mContext, "No Service Provider is available", Toast.LENGTH_SHORT).show()
            } else {
                canGetLocation = true

                val providers: List<String> = locationManager!!.getProviders(true)
                var bestLocation: Location? = null
                if (ActivityCompat.checkSelfPermission(mContext as Activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return null
                }
                for (provider in providers) {
                    val l: Location = locationManager!!.getLastKnownLocation(provider) ?: continue
                    if (bestLocation == null || l.accuracy < bestLocation.accuracy) {
                        // Found best last known location: %s", l);
                        bestLocation = l
                    }
                }
                return bestLocation
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return loc
    }

    fun canGetLocation(): Boolean {
        return canGetLocation
    }

    fun showSettingsAlert() {
        val alertDialog = AlertDialog.Builder(mContext)
        alertDialog.setTitle("GPS is not Enabled!")
        alertDialog.setMessage("Do you want to turn on GPS?")
        alertDialog.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            mContext.startActivity(intent)
        })
        alertDialog.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
        alertDialog.show()
    }


    fun stopListener() {
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission((mContext as Activity), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return
            }
            locationManager!!.removeUpdates(this@LocationTrack)
        }
    }


    override fun onLocationChanged(location: Location?) {

    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

    }

    override fun onProviderEnabled(provider: String?) {

    }

    override fun onProviderDisabled(provider: String?) {

    }

    companion object{
        val ALL_PERMISSIONS_RESULT = 1011
    }
}
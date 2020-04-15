/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 */

package com.sunflower.pantaucovid19.utils

import android.content.Context
import android.location.Address
import android.location.Geocoder
import java.util.*

/**
 * City = Kota
 * State = Provinsi
 * Country = Negara
 * */
data class LocationsObject(var city : String?,var state : String?
                           ,var country : String?)

/**
 * A helper for geography
 * @param latitude Provide latitude from Coordinate in double
 * @param longitude Provide longitude from Coordinate in double
 * @param context Instance caller
 * */
class Geography(latitude : Double,longitude : Double,context : Context) {
    var mContext = context
    var lat = latitude
    var long = longitude
    var geo : Geocoder? = null
    var addresses: List<Address>? = null

    init{
        geo = Geocoder(this.mContext.applicationContext, Locale.getDefault())
         addresses = geo!!.getFromLocation(lat, long, 1)
    }

    fun getLocationObject():LocationsObject{
        println("ADRESS: "+addresses!!.toString())
        val cityName = addresses!![0].subAdminArea
        val stateName = addresses!![0].adminArea
        val countryName = addresses!![0].countryName
        return LocationsObject(cityName,stateName,countryName)
    }
}
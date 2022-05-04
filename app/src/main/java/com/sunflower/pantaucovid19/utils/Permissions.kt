/*
 * Copyright (c) 2020.
 * Davin Alfarizky Putra Basudewa <dbasudewa@gmail.com> <rootdavin@yahoo.co.jp>
 * dvnlabs.xyz 2020 All rights reserved
 * This portion of code is written by Davin Alfarizky P.B , please to concern effort from him.
 */

package com.sunflower.pantaucovid19.utils

import android.content.Context
import android.os.Build
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission

class Permissions(context: Context) {
    var mContext = context
    fun permissionsToRequest(wantedPermissions: ArrayList<String>): ArrayList<String>? {
        val result: ArrayList<String> = ArrayList()
        for (perm in wantedPermissions) {
            if (!hasPermission(perm)) {
                result.add(perm)
            }
        }
        return result
    }

    private fun hasPermission(permission: String): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkSelfPermission(mContext, permission) == PermissionChecker.PERMISSION_GRANTED
        } else true
    }
}
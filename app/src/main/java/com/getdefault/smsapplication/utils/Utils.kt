package com.getdefault.smsapplication.utils

import android.content.Context
import android.content.SharedPreferences

class Utils {

    object Util {

        fun getAuthToken(context: Context): String {
            val sp: SharedPreferences =
                context.getSharedPreferences(Constants.Util.SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return "Bearer " + sp.getString(Constants.Util.SESSION_AUTH_TOKEN, "")
        }

         fun setAuthToken(context: Context, token: String) {
            val sp =
                context.getSharedPreferences(Constants.Util.SHARED_PREF_NAME, Context.MODE_PRIVATE)
            val editor = sp.edit()
            editor.putString(Constants.Util.SESSION_AUTH_TOKEN, token)
            editor.apply()
        }
    }
}

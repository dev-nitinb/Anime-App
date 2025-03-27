package com.example.animeapp.utils

import android.content.Context
import android.net.ConnectivityManager

class ConnectionDetector {
    fun isConnected(context: Context):Boolean{
        val connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo=connectivityManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnectedOrConnecting
    }
}
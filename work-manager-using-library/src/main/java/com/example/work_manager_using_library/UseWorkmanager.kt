package com.example.work_manager_using_library

import android.content.Context
import android.util.Log
import androidx.work.WorkManager

class UseWorkmanager {
    fun use(context: Context) {
      Log.e("WorkManager", WorkManager.getInstance(context).toString())
        // Use WorkManager here
    }
}
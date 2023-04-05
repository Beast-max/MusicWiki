package com.example.musicwiki.utils

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication:Application() {
    override fun onCreate() {
        mcontext = this
        super.onCreate()
    }
    companion object{
        lateinit var mcontext: BaseApplication
        fun getContext(): Context {
            return mcontext.applicationContext
        }

    }
}
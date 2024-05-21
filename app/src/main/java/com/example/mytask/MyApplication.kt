package com.example.mytask

import android.app.Application
import com.example.modulea.MyApp
import com.example.modulea.di.ApplicationComponent
import com.example.modulea.di.DaggerApplicationComponent

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MyApp.applicationComponent = DaggerApplicationComponent.factory().create(this)
        MyApp.app = this


    }

}
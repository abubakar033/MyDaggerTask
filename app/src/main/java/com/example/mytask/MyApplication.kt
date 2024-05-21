package com.example.mytask

import android.app.Application
import com.example.modulea.MyApp
import com.example.modulea.di.DaggerModuleAComponent

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MyApp.applicationComponent = DaggerModuleAComponent.factory().create(this)
        MyApp.app = this


    }

}
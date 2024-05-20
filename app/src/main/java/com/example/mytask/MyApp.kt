package com.example.mytask

import android.app.Application
import android.content.Context
import com.example.modulea.di.DaggerApplicationComponent

//import com.example.mytask.di.ApplicationComponent
//import com.example.mytask.di.DaggerApplicationComponent


class MyApp : Application() {

 //   lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        //applicationComponent = DaggerApplicationComponent.factory().create(this)

    }

//    companion object {
//        fun getAppComponent(context: Context): ApplicationComponent {
//            return (context.applicationContext as MyApp).applicationComponent
//        }
//    }
}
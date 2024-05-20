package com.example.modulea.di

import android.content.Context
import com.example.modulea.ui.ListingScreen
import com.example.modulea.database.DatabaseModule
import com.example.modulea.di.module.RepositoryModule
import com.example.modulea.di.module.UseCaseModule
import com.example.modulea.netowork.NetworkModule
import com.example.modulea.viewmodel.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    DatabaseModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    UseCaseModule::class])
interface ApplicationComponent{
    fun inject(fragment: ListingScreen)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}




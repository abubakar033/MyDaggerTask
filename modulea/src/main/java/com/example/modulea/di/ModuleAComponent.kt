package com.example.modulea.di

import android.content.Context
import com.example.modulea.ui.ListingScreen
import com.example.modulea.di.module.DatabaseModule
import com.example.modulea.di.module.RepositoryModule
import com.example.modulea.di.module.UseCaseModule
import com.example.modulea.di.module.NetworkModule
import com.example.modulea.di.module.ViewModelModule
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
interface ModuleAComponent{
    fun inject(fragment: ListingScreen)
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ModuleAComponent
    }

}




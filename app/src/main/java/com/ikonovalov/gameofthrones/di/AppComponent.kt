package com.ikonovalov.gameofthrones.di

import com.ikonovalov.gameofthrones.presentation.viewmodel.DetailViewModel
import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent{

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun getListViewModel(): ListViewModel

    fun getDetailViewModel(): DetailViewModel
}
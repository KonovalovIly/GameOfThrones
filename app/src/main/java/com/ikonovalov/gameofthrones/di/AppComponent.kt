package com.ikonovalov.gameofthrones.di

import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent{

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun getListViewModel(): ListViewModel
}
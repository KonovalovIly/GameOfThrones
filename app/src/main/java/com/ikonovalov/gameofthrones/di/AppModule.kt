package com.ikonovalov.gameofthrones.di

import com.ikonovalov.gameofthrones.data.RepositoryImpl
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.presentation.viewmodel.DetailViewModel
import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [NetworkModule::class, AppBindModule::class])
class AppModule{

    @Provides
    fun provideListViewModel(repository: Repository): ListViewModel = ListViewModel(repository)

    @Provides
    fun provideDetailViewModel(repository: Repository): DetailViewModel = DetailViewModel(repository)

}

@Module
interface AppBindModule{

    @Suppress("FunctionName")
    @Binds
    fun bindRepositoryImpl_To_Repository(repositoryImpl: RepositoryImpl): Repository

}
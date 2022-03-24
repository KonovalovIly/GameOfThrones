package com.ikonovalov.gameofthrones.di

import com.ikonovalov.gameofthrones.data.RepositoryImpl
import com.ikonovalov.gameofthrones.domain.Repository
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterDetailUseCase
import com.ikonovalov.gameofthrones.domain.usecases.GetCharacterListUseCase
import com.ikonovalov.gameofthrones.presentation.viewmodel.DetailViewModel
import com.ikonovalov.gameofthrones.presentation.viewmodel.ListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(includes = [NetworkModule::class, AppBindModule::class])
class AppModule{

    @Provides
    fun provideListViewModel(getCharacterListUseCase: GetCharacterListUseCase): ListViewModel = ListViewModel(getCharacterListUseCase)

    @Provides
    fun provideDetailViewModel(getCharacterDetailUseCase: GetCharacterDetailUseCase): DetailViewModel = DetailViewModel(getCharacterDetailUseCase)

}

@Module
interface AppBindModule{

    @Suppress("FunctionName")
    @Binds
    fun bindRepositoryImpl_To_Repository(repositoryImpl: RepositoryImpl): Repository

}
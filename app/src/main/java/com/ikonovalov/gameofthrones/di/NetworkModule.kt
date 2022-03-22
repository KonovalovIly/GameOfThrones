package com.ikonovalov.gameofthrones.di

import com.ikonovalov.gameofthrones.data.CharacterServiceWithImageApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterServiceWithImageApi = retrofit.create()


    @Provides
    fun retrofit(): Retrofit = Retrofit.Builder()
            .baseUrl("https://thronesapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}
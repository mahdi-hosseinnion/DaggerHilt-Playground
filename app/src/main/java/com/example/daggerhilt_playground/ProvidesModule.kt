package com.example.daggerhilt_playground

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProvidesModule {

    @Singleton
    @Provides
    fun provideEspressoMaker(): EspressoMaker {
        return ElectricEspressoMaker()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()


}
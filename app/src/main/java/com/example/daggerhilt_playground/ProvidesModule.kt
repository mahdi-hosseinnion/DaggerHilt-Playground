package com.example.daggerhilt_playground

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
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

    const val coffeeShopName_tag = "coffeeShopName"

    @Named(coffeeShopName_tag)
    @Singleton
    @Provides
    fun provideCoffeeShopName(): String = "three soot coffee"

    const val coffeeShopOwnerName_tag = "coffeeShopOwnerName"

    @Named(coffeeShopOwnerName_tag)
    @Singleton
    @Provides
    fun provideCoffeeShopOwnerName(): String = "ahmad jalali"

    @EspressoPrice
    @Singleton
    @Provides
    fun provideEspressoPrice(): Int = 12

    @CappuccinoPrice
    @Singleton
    @Provides
    fun provideCappuccinoPrice(): Int = 55


}


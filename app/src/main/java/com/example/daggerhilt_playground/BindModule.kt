package com.example.daggerhilt_playground

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {

    @Singleton
    @Binds
    abstract fun bindMilkHeater(
        gasMilkHeater: GasMilkHeater
    ): MilkHeater


}
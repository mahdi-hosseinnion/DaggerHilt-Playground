package com.example.daggerhilt_playground

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EspressoPrice

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class CappuccinoPrice
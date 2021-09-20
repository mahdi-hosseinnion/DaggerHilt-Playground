package com.example.daggerhilt_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    //    field injection examp
    @Inject
    lateinit var cappuccinoMaker: CappuccinoMaker

    @Inject
    lateinit var cappuccinoMaker2: CappuccinoMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: cappuccino: ${cappuccinoMaker.hashCode()}")
        Log.d(TAG, "onCreate: cappuccino: ${cappuccinoMaker2.hashCode()}")
    }
}

//field injection example
//@Singleton
class CappuccinoMaker
//@Inject
constructor(
    //constructor injection example
    private val milkHeater: MilkHeater
) {

    fun makeTheEspresso(): String {
        return "Espresso have been made"
    }

    fun makeTheMilkHot(): String {
        return milkHeater.makeTheMilkHot()
    }

}

//constructor injection example
class MilkHeater
@Inject
constructor() {

    fun makeTheMilkHot(): String {
        return "Milk is ready"
    }

}

@Module
@InstallIn(ActivityComponent::class)
object SomeModule {
    @Provides
    @ActivityScoped
    fun provideCappuccinoMaker(milkHeater: MilkHeater): CappuccinoMaker {
        return CappuccinoMaker(milkHeater)
    }
}
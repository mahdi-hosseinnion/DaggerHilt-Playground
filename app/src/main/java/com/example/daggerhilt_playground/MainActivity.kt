package com.example.daggerhilt_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
//    field injection examp
    @Inject
    lateinit var cappuccinoMaker: CappuccinoMaker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: cappuccino: ${cappuccinoMaker.makeTheMilkHot()}")
        Log.d(TAG, "onCreate: cappuccino: ${cappuccinoMaker.makeTheEspresso()}")
    }
}
//field injection example
class CappuccinoMaker
@Inject
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
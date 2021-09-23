package com.example.daggerhilt_playground

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerhilt_playground.ProvidesModule.coffeeShopName_tag
import com.example.daggerhilt_playground.ProvidesModule.coffeeShopOwnerName_tag
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    //    field injection examp
    @Inject
    lateinit var cappuccinoMaker: CappuccinoMaker

    @Named(coffeeShopName_tag)
    @Inject
    lateinit var coffeeShopName: String

    @Named(coffeeShopOwnerName_tag)
    @Inject
    lateinit var coffeeShopOwnerName: String

    @JvmField
    @EspressoPrice
    @Inject
    var espressoPrice: Int = -1

    @JvmField
    @CappuccinoPrice
    @field:[Inject]
    var cappuccinoPrice: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(
            TAG,
            "onCreate: welcome to '$coffeeShopName', I'm the owner mr '$coffeeShopOwnerName'"
        )
        Log.d(
            TAG,
            "onCreate: menu: \n espressoPrice: $espressoPrice \n cappuccinoPrice:$cappuccinoPrice"
        )

//        Log.d(TAG, "onCreate: cappuccino: ${cappuccinoMaker.makeTheCappuccino()}")

    }
}

@ActivityScoped
class CappuccinoMaker
@Inject
constructor(
    private val espressoMaker: EspressoMaker,
    private val milkHeater: MilkHeater,
    private val gson: Gson
) {

    fun makeTheCappuccino(): String {
        Log.d("MainActivity", "makeTheCappuccino: ${espressoMaker.makeTheEspresso()}")
        Log.d("MainActivity", "makeTheCappuccino: ${milkHeater.makeTheMilkHot()}")
        Log.d("MainActivity", "myGSON: ${gson.hashCode()}")
        return "Cappuccino have been made"
    }

}

interface MilkHeater {
    fun makeTheMilkHot(): String
}

class GasMilkHeater
@Inject
constructor() : MilkHeater {

    override fun makeTheMilkHot(): String {
        return "Milk is ready"
    }

}

interface EspressoMaker {
    fun makeTheEspresso(): String
}

class ElectricEspressoMaker : EspressoMaker {

    override fun makeTheEspresso(): String {
        return "Espresso is ready"
    }

}


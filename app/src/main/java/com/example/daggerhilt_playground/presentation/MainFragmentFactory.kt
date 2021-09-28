package com.example.daggerhilt_playground.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainFragmentFactory
@Inject
constructor(
    private val blogName: String
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =
        when (className) {
            MainFragment::class.java.name -> {
                MainFragment(blogName = blogName)
            }
            else -> super.instantiate(classLoader, className)
        }


}
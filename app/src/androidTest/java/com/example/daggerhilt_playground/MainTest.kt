package com.example.daggerhilt_playground

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun beforeBlock() {
        hiltRule.inject()
    }

    @Test
    fun dummyTest() {
        Assert.assertSame(4, 2 + 2)
    }

    @Test
    fun dummyTest2() {
        throw Exception("Hello")
    }
}
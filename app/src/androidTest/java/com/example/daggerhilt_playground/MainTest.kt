package com.example.daggerhilt_playground

import androidx.test.core.app.launchActivity
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.daggerhilt_playground.di.AppModule
import com.example.daggerhilt_playground.presentation.MainActivity
import com.example.daggerhilt_playground.presentation.MainFragment
import com.example.daggerhilt_playground.presentation.MainFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import junit.framework.Assert.assertSame
import org.hamcrest.CoreMatchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@HiltAndroidTest
class MainTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var blogName: String

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    @Before
    fun beforeBlock() {
        hiltRule.inject()
    }

    @Test
    fun test_HiltModuleReplacement() {
        assertThat(blogName, containsString("Test"))
        assertSame(blogName, TestAppModule.provideBlogName())
    }

    @Test
    fun test_mainActivity() {
        val scenario = launchActivity<MainActivity>()
    }

    @Test
    fun test_mainFragment() {
        val scenario = launchFragmentInHiltContainer<MainFragment>(
            factory = fragmentFactory
        )
    }

}

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {
    @Singleton
    @Provides
    fun provideBlogName(): String = "Test blog name"

    @Singleton
    @Provides
    fun provideDate(): Date = Date(123_456_789)
}
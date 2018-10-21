package me.vponomarenko.androidcircleci

import android.support.annotation.StringRes
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.doubleClick
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



/**
 * Author: Valery Ponomarenko
 * Date: 11/10/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    private val textReverser = TextReverser()

    @Test
    fun helloWorldIsDisplayed() {
        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))
    }

    @Test
    fun onClickMeButtonClicked() {
        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))

        onView(withId(R.id.button_click_me)).perform(click())

        val reversedText = textReverser.reverse(getResourceString(R.string.hello_world))
        onView(withId(R.id.text_main)).check(matches(withText(reversedText)))
    }

    @Test
    fun onClickMeButtonDoubleClicked() {
        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))

        onView(withId(R.id.button_click_me)).perform(doubleClick())

        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))
    }

    private fun getResourceString(@StringRes id: Int): String {
        val targetContext = InstrumentationRegistry.getTargetContext()
        return targetContext.resources.getString(id)
    }

}
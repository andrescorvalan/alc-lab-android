package com.curso.android.app.practica.pairstring.view

//import org.junit.jupiter.api.Assertions.*
import android.view.KeyEvent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityStringsIguales(){
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString1)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString1)
        ).perform(
            ViewActions.pressKey(KeyEvent.KEYCODE_A)
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString2)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString2)
        ).perform(
            ViewActions.pressKey(KeyEvent.KEYCODE_A)
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.ButtonCompare)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.TextViewResult)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(com.curso.android.app.practica.pairstring.R.string.mje_equal)
            )
        )
    }
    @Test
    fun mainActivityStringsDistintos(){
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString1)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString1)
        ).perform(
            ViewActions.pressKey(KeyEvent.KEYCODE_A)
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString2)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.EditTextString2)
        ).perform(
            ViewActions.pressKey(KeyEvent.KEYCODE_B)
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.ButtonCompare)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(com.curso.android.app.practica.pairstring.R.id.TextViewResult)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(com.curso.android.app.practica.pairstring.R.string.mje_distint)
            )
        )
    }
}
package com.mainduelo.marcadordetruco

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.mainduelo.marcadordetruco.activity.MainActivity
import android.support.test.rule.ActivityTestRule
import android.widget.Button
import android.widget.TextView
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var rule = ActivityTestRule (MainActivity :: class.java)

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.mainduelo.marcadordetruco", appContext.packageName)
    }

    @Test
    fun buttonTextActionScoreTeam1(){
        var button: Button = rule.activity.findViewById(R.id.buttonTeam1More1)
        assertEquals("+1",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam1More3)
        assertEquals("+3",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam1More6)
        assertEquals("+6",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam1More9)
        assertEquals("+9",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam1More12)
        assertEquals("+12",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam1Minus1)
        assertEquals("-1",button.text)
    }

    @Test
    fun buttonTextActionScoreTeam2(){
        var button: Button = rule.activity.findViewById(R.id.buttonTeam2More1)
        assertEquals("+1",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam2More3)
        assertEquals("+3",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam2More6)
        assertEquals("+6",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam2More9)
        assertEquals("+9",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam2More12)
        assertEquals("+12",button.text)
        button  = rule.activity.findViewById(R.id.buttonTeam2Minus1)
        assertEquals("-1",button.text)
    }

    @Test
    fun textViewScoreTeam1(){
        var textView: TextView = rule.activity.findViewById(R.id.textViewVictoryTeam1)
        assertEquals("0",textView.text)
        textView = rule.activity.findViewById(R.id.textViewScoreTeam1)
        assertEquals("0",textView.text)
    }

    @Test
    fun textViewScoreTeam2(){
        var textView: TextView = rule.activity.findViewById(R.id.textViewVictoryTeam2)
        assertEquals("0",textView.text)
        textView = rule.activity.findViewById(R.id.textViewScoreTeam2)
        assertEquals("0",textView.text)
    }
}

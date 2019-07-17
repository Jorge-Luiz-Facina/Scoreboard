package com.mainduelo.marcadordetruco

import kotlin.math.floor

class TimeTable {

    companion object {
        public val instance = TimeTable()
    }

    public fun formatHHMMSS(time : Int): String{
        var hours = floor((time.toFloat() % 216000) / 3600).toInt()
        var minutes = floor((time.toFloat() % 3600)/60).toInt()
        var seconds = floor((time.toFloat() % 60)).toInt()
        return  String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }
}

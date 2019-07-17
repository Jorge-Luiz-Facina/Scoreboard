package com.mainduelo.marcadordetruco

import org.junit.Test
import org.junit.Assert.*

class TimeTableTest {

    val timeTable: TimeTable = TimeTable()
    @Test
    fun secondsTest() {
        assertEquals("00:00:00", timeTable.formatHHMMSS(0))
        assertEquals("00:00:07", timeTable.formatHHMMSS(7))

        for (i in 10..59)
            assertEquals("00:00:$i", timeTable.formatHHMMSS(i))
    }

    @Test
    fun minutesTest(){
        assertEquals("00:01:00", timeTable.formatHHMMSS(formatMinutesInSeconds(1)))
        assertEquals("00:04:00", timeTable.formatHHMMSS(formatMinutesInSeconds(4)))
        assertEquals("00:10:00", timeTable.formatHHMMSS(formatMinutesInSeconds(10)))
    }

    @Test
    fun hoursTest(){
        assertEquals("01:00:00", timeTable.formatHHMMSS(formatHoursInSeconds(1)))
        assertEquals("09:00:00", timeTable.formatHHMMSS(formatHoursInSeconds(9)))
        assertEquals("59:00:00", timeTable.formatHHMMSS(formatHoursInSeconds(59)))
    }

    @Test
    fun randomTime(){
        assertEquals("04:02:07", timeTable.formatHHMMSS((formatHoursInSeconds(4)) + formatMinutesInSeconds(2) + 7))
        assertEquals("15:09:08", timeTable.formatHHMMSS((formatHoursInSeconds(15)) + formatMinutesInSeconds(9) + 8))
        assertEquals("52:27:31", timeTable.formatHHMMSS((formatHoursInSeconds(52)) + formatMinutesInSeconds(27) + 31))
    }

    private fun formatMinutesInSeconds(hours: Int): Int{
        return hours * 60
    }

    private fun formatHoursInSeconds(hours: Int): Int{
        return hours * 3600
    }
}

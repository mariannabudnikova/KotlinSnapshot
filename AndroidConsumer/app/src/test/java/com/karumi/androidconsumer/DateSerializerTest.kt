package com.karumi.androidconsumer

import com.karumi.kotlinsnapshot.matchWithSnapshot
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateSerializerTest {
    @Test
    fun serializesAnyDateUsingTheExpectedSerializationFormat() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd:HH:mm:ss.SSS", Locale.US)
        dateFormat.timeZone = TimeZone.getTimeZone("GMT")
        val date = dateFormat.parse("2007-12-03:18:46:19.111")
        date.matchWithSnapshot()
    }
}

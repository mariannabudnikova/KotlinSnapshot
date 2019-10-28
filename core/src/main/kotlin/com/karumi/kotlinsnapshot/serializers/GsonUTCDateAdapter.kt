package com.karumi.kotlinsnapshot.serializers

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class GsonUTCDateAdapter : JsonSerializer<Date> {

    private val dateFormat: DateFormat

    init {
        // SSSX is the default parser, but it is not supported by Android
        // Fallback to SSSZ parsing if the adapter is used in Android project
        dateFormat = try {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX", Locale.US)
        } catch (e: IllegalArgumentException) {
            SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.US)
        }
        dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    }

    @Synchronized
    override fun serialize(
        date: Date,
        type: Type,
        jsonSerializationContext: JsonSerializationContext
    ): JsonElement =
            JsonPrimitive(dateFormat.format(date))
}

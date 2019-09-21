package com.yogiputra.basemvvm.core.utils

import android.annotation.SuppressLint
import android.text.format.DateFormat
import com.yogiputra.basemvvm.core.utils.DateUtils.LOCALE
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by oohyugi on 2019-09-18.
 */
object DateUtils {
    const val DATE_DEFAULT = "yyyy-MM-dd"

    const val DATE_DEFAULT_WITH_TIME = "yyyy-MM-dd HH:mm"
    const val DATE_DDMMYYYY = "dd-MM-yyyy"
    const val DATE_EEDDMMMYYYY = "EEEE, dd MMMM yyyy"
    const val DATE_DDMMMMYYYY = "dd MMMM yyyy"
    const val DATE_YYYY_MM_DD = "yyyy/MM/dd"
    const val DATE_YYYY_MM_DD_WITH_TIME = "yyyy/MM/dd HH:mm"
    const val DATE_SERVER = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val LOCALE = "ID"
}


@SuppressLint("SimpleDateFormat")
fun String.changeFormatDate(old_format: String, formatDate: String): String {
    return try {
        val sdf = SimpleDateFormat(old_format)
        val date: Date?
        date = sdf.parse(this)
        val id = Locale("in", LOCALE)
        val format = SimpleDateFormat(formatDate, id)
        format.format(date!!)
    } catch (e: ParseException) {
        this
    }

}

fun Date.dateParseToString(old_format: String): String {
    val id = Locale("in", LOCALE)
    val format = SimpleDateFormat(old_format, id)
    return format.format(this)
}

fun String.dateParseToDate(old_format: String): Date? {
    return try {
        val id = Locale("in", LOCALE)
        val sdf = SimpleDateFormat(old_format, id)
        sdf.parse(this)
    } catch (e: Exception) {
        null
    }

}

@SuppressLint("SimpleDateFormat")
fun Long.convertToTimeString(format: String): String {

    return try {
        val dateLong = Date(this * 1000L)
        val date = DateFormat.format(format, dateLong).toString()

        val formatter = SimpleDateFormat(format)
        val value = formatter.parse(date)

        val dateFormatter = SimpleDateFormat(format)
        dateFormatter.timeZone = TimeZone.getDefault()
        dateFormatter.format(value)
    } catch (e: java.lang.Exception) {
        "$this"
    }
}


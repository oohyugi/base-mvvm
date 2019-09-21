package com.yogiputra.basemvvm.data.source.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogiputra.basemvvm.core.model.DriverActiveMdl
import com.yogiputra.basemvvm.core.model.UserActiveMdl


/**
 * Created by oohyugi on 2019-09-20.
 */
class Converters {
    @TypeConverter
    fun fromStringUserActive(value: String?): UserActiveMdl? {
        val listType = object : TypeToken<UserActiveMdl>() {

        }.type
        return if (value != null) {
            Gson().fromJson(value, listType)
        } else {
            null
        }


    }

    @TypeConverter
    fun fromUserActiveMdl(userActive: UserActiveMdl?): String? {
        val gson = Gson()
        return if (userActive != null) {
            gson.toJson(userActive)
        } else {
            null
        }

    }

    @TypeConverter
    fun fromStringDriverActive(value: String?): DriverActiveMdl? {
        val listType = object : TypeToken<DriverActiveMdl>() {

        }.type
        return if (value != null) {
            Gson().fromJson(value, listType)
        } else {
            null
        }

    }

    @TypeConverter
    fun fromDriverActiveMdl(driverActiveMdl: DriverActiveMdl?): String? {
        val gson = Gson()

        return if (driverActiveMdl != null) {
            gson.toJson(driverActiveMdl)
        } else {
            null
        }
    }
}
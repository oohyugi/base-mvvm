package com.yogiputra.basemvvm.core.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.yogiputra.basemvvm.data.source.local.Converters

@Entity
data class MartboxMdl(

    @PrimaryKey
    @SerializedName("mart_box_id")
    val martBoxId: Int = 0,
    @ColumnInfo(name = "store_code")
    @SerializedName("store_code")
    val storeCode: String? = null,
    @ColumnInfo(name = "user_active")
    @TypeConverters(Converters::class)
    @SerializedName("user_active")
    val userActive: UserActiveMdl? = null,
    @ColumnInfo(name = "updated_at")
    @SerializedName("updated_at")
    val updatedAt: String = "",
    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    val createdAt: String = "",
    @ColumnInfo(name = "driver_active")
    @TypeConverters(Converters::class)
    @SerializedName("driver_active")
    val driverActiveMdl: DriverActiveMdl? = null,
    @ColumnInfo(name = "mart_id_display")
    @SerializedName("mart_id_display")
    val martIdDisplay: String = "",
    @ColumnInfo(name = "menu_id")
    @SerializedName("menu_id")
    val menuId: Int = 0,
    @ColumnInfo(name = "location_id")
    @SerializedName("location_id")
    val locationId: Int = 0,
    @ColumnInfo(name = "status")
    @SerializedName("status")
    val status: Int = 0
)


data class UserActiveMdl(
    @SerializedName("data")
    val userActiveMdl: UserActiveDataMdl
)

data class UserActiveDataMdl(
    @SerializedName("user_id")
    val userId: Int = 0,
    @SerializedName("user_uuid")
    val userUuid: String? = null
)

data class DriverActiveMdl(
    @SerializedName("data")
    val driverActiveData: DriverActiveDataMdl
)

data class DriverActiveDataMdl(
    @SerializedName("driver_id")
    val driverId: Int = 0,
    @SerializedName("licence_number")
    val licenceNumber: String? = null,
    @SerializedName("driver_uuid")
    val driverUuid: String = ""
)
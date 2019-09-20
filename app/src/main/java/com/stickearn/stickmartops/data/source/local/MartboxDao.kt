package com.stickearn.stickmartops.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.stickearn.stickmartops.core.model.MartboxMdl

/**
 * Created by oohyugi on 2019-09-20.
 */
@Dao
interface MartboxDao {
    @Query("SELECT * FROM martboxmdl")
    fun getAllMartbox(): List<MartboxMdl>

    @Insert
    fun insertMartbox(martboxMdl: MartboxMdl)
}
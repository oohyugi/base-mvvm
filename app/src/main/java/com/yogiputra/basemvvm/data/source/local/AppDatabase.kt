package com.yogiputra.basemvvm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yogiputra.basemvvm.core.model.MartboxMdl

/**
 * Created by oohyugi on 2019-09-20.
 */
@Database(entities = [MartboxMdl::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun martboxDao(): MartboxDao

    companion object {
        const val DATABASE_NAME: String = "stickmartops.db"


//        fun getInstance(context: Context): AppDatabase? {
//            if (INSTANCE == null) {
//                synchronized(AppDatabase::class) {
//                    INSTANCE = Room.databaseBuilder(context.applicationContext,
//                        AppDatabase::class.java, "stickmartops.db")
//                        .build()
//                }
//            }
//            return INSTANCE
//        }
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }
    }
}


package com.getdefault.smsapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.getdefault.smsapplication.data.db.entity.SMSEntity
import kotlinx.coroutines.CoroutineScope

@Database(entities = [SMSEntity::class], version = 1, exportSchema = false)
abstract class SMSDatabase : RoomDatabase() {

    abstract fun sMSDao(): SMSDao

    companion object {
        @Volatile
        var INSTANCE: SMSDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): SMSDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SMSDatabase::class.java,
                    "sms_database"
                ).addCallback(SMSDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class SMSDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
            }
        }

    }
}

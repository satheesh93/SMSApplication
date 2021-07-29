package com.getdefault.smsapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.getdefault.smsapplication.data.db.entity.SMSEntity

@Dao
interface SMSDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.

    @Query("SELECT * from sms_table")
    fun getAllMessages(): LiveData<SMSEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: SMSEntity)
}

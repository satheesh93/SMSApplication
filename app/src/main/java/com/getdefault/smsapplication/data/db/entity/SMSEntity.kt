package com.getdefault.smsapplication.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sms_table")
data class SMSEntity(
    @PrimaryKey(autoGenerate = true)  var id: Int? = 0,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "message") var message: String
)
package com.getdefault.smsapplication.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.getdefault.smsapplication.data.db.SMSDao
import com.getdefault.smsapplication.data.db.entity.SMSEntity


//class SMSRepository(private val smsDao: SMSDao) {
class SMSRepository {

    object smsRepository{
        private val mData: MediatorLiveData<SMSEntity> = MediatorLiveData<SMSEntity>()

        fun getData(): LiveData<SMSEntity> {
            return mData
        }

        fun addDataSource(data: LiveData<SMSEntity?>?) {
            mData.addSource(data!!) { value: SMSEntity? -> mData.setValue(value) }
        }

        fun removeDataSource(data: LiveData<SMSEntity?>?) {
            mData.removeSource(data!!)
        }
    }

}
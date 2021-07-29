package com.getdefault.smsapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.getdefault.smsapplication.data.db.entity.SMSEntity
import com.getdefault.smsapplication.data.repository.SMSRepository


class SMSListViewModel(application: Application) : AndroidViewModel(application) {

    val smsData = SMSRepository.smsRepository.getData()


//    init {
//        val smsDao = SMSDatabase.getDatabase(application, viewModelScope).sMSDao()
//        smsRepository = SMSRepository(smsDao)
//    }
//
//    fun insert(smsEntity: SMSEntity) = viewModelScope.launch {
//        smsRepository.insert(smsEntity)
//    }


}
package com.getdefault.smsapplication.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData
import com.getdefault.smsapplication.data.db.entity.SMSEntity


class SMSReceiver : BroadcastReceiver() {

    val pdu_type = "pdus"
    var pdus: Array<*>? = null

    private val mData: MutableLiveData<SMSEntity> = MutableLiveData<SMSEntity>()

    override fun onReceive(context: Context, intent: Intent) {

        val bundle = intent.extras
        val msgs: Array<SmsMessage?>
        val format = bundle!!.getString("format")

        pdus = bundle[pdu_type] as Array<*>?
        if (pdus != null) {
            msgs = arrayOfNulls(pdus!!.size)
            for (i in msgs.indices) {
                msgs[i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray, format)

                mData.value = SMSEntity(null, msgs[i]?.originatingAddress!!, msgs[i]?.messageBody!!)



//                    viewModel.insert(
//                        SMSEntity(
//                            null,
//                            msgs[i]?.originatingAddress!!,
//                            msgs[i]?.messageBody!!
//                        )
//                    )
            }
        }
    }

}
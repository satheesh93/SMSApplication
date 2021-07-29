package com.getdefault.smsapplication.view

import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.getdefault.smsapplication.R
import com.getdefault.smsapplication.databinding.ActivityMainBinding
import com.getdefault.smsapplication.receiver.SMSReceiver
import com.getdefault.smsapplication.viewmodel.SMSListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: SMSListViewModel

    lateinit var receiver: SMSReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(receiver, IntentFilter())
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    private fun init() {
        setViewModel()
        setUI()
    }

    private fun setUI() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(this).get(SMSListViewModel::class.java)
        viewModel.smsData.observe(this, {
            //todo
            Log.i("Message","hiiiii ${it.message}")
        })

        receiver = SMSReceiver()
    }
}


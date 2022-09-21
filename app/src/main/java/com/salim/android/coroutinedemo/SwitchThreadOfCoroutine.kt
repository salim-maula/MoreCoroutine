package com.salim.android.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.salim.android.coroutinedemo.databinding.ActivityMainBinding
import com.salim.android.coroutinedemo.databinding.ActivitySwitchThreadOfCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SwitchThreadOfCoroutine : AppCompatActivity() {

    private lateinit var binding: ActivitySwitchThreadOfCoroutineBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchThreadOfCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private suspend  fun downloadUserData() {

        //this will error
//        for (i in 1..200000) {
//                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
//        }

        for (i in 1..200000) {
            withContext(Dispatchers.Main){
                binding.tvUserMessage.text = "Downloading user $i in ${Thread.currentThread().name}"
            }
        }
    }
}

//suspending function withContext,
// withTimeOut, withTimeoutOrNull, Join, delay,
// await, supervisorScope, coroutineScope
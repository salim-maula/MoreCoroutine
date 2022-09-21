package com.salim.android.coroutinedemo.unstructuredconcoruncy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.salim.android.coroutinedemo.databinding.ActivityUnstructuredBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UnstructuredActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUnstructuredBinding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUnstructuredBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {

            //Now Change IO to Main
            CoroutineScope(Dispatchers.Main).launch {
//                downloadUserData()
//                binding.tv UserMessage.text = UserDataManager1().getTotalUserCount().toString()
                binding.tvUserMessage.text = UserDataManager2().getTotalUserCount().toString()
            }
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }

}

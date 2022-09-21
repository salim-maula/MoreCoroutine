package com.salim.android.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.salim.android.coroutinedemo.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }
        binding.btnDownloadUserData.setOnClickListener {

            //use coroutine

            //1. Coroutines are like just separate processors running on a thread. So, In order to use co routines,
            //2. Dalam satu thread kita bisa menjalankan banyak coroutine, hal ini pastinya
            //akan membuat leaks dan performance aplikasi meneurun
            //kotlin mengsolve semua itu dengan membuatnya sebuah scope
            //sehingga kita dapat dengan mudah melkukan tracking, cancel handle error ataupun exception

            //selain CoroutineScope kita juga bisa membuat dengan GlobalScope
            //GlobalScoped is used to launch top-level coroutine which are operating on the whole application lifetime

            //launch is the coroutine builder


            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
            //move code to coroutine
//            downloadUserData()
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}
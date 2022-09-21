package com.salim.android.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChallengeOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chalange_one)

        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MyTag", "onCreate: Hello from ${Thread.currentThread().name}")
        }
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("MyTag", "onCreate: Hello from ${Thread.currentThread().name}")
        }

        CoroutineScope(Dispatchers.Main).launch {
            Log.i("MyTag", "onCreate: Hello from ${Thread.currentThread().name}")
        }
    }
}
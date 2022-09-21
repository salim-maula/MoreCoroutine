package com.salim.android.coroutinedemo.lifcyeclescope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.salim.android.coroutinedemo.R
import com.salim.android.coroutinedemo.databinding.ActivityThirdBinding
import com.salim.android.coroutinedemo.lifcyeclescope.ui.main.ThirdFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ThirdFragment.newInstance())
                .commitNow()
        }

        lifecycleScope.launch(Dispatchers.IO){
            Log.i("MyTag", "Activity: ${Thread.currentThread().toString()}")
        }
    }
}
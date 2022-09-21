package com.salim.android.coroutinedemo.lifcyeclescope.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.salim.android.coroutinedemo.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: ThirdViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ThirdViewModel::class.java)
        // TODO: Use the ViewModel

        lifecycleScope.launch(Dispatchers.IO){
            Log.i("MyTag", "launch: ${Thread.currentThread().toString()}")
        }
        lifecycleScope.launchWhenCreated {
            Log.i("MyTag", "launchWhenCreated: ${Thread.currentThread().toString()}")
        }
        lifecycleScope.launchWhenStarted {
            Log.i("MyTag", "launchWhenStarted: ${Thread.currentThread().toString()}")
        }
        lifecycleScope.launchWhenResumed {
            Log.i("MyTag", "launchWhenResumed: ${Thread.currentThread().toString()}")
        }
    }

}
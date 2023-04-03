package com.example.lottieandroidissue2271

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.lottie.LottieListener
import com.example.lottieandroidissue2271.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), LottieListener<Throwable> {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initViews() {
        binding.validJsonUrl.setFailureListener(this)
        binding.validJsonWithPlaceholder.setFailureListener(this)
        binding.invalidJsonUrl.setFailureListener(this)
        binding.invalidJsonWithPlaceholder.setFailureListener(this)
    }

    override fun onResult(result: Throwable?) {
        Log.e(TAG, "onResult: ", result)
    }
}
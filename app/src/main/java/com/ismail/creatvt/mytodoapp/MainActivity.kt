package com.ismail.creatvt.mytodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ismail.creatvt.mytodoapp.R
import com.ismail.creatvt.mytodoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        binding.lifecycleOwner = this
        binding.viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}
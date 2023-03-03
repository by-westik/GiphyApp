package com.by_westik.example.giphyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.by_westik.example.giphyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
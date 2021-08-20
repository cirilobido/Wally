package com.cirilobido.wally.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cirilobido.wally.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_Wally)
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_splash_screen)
        startActivity(Intent(this, MainActivity::class.java))
    }
}
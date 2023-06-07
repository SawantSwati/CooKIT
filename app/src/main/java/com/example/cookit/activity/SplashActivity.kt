package com.example.cookit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.cookit.R
import com.example.cookit.data.AddDataInDatabase
import com.example.cookit.util.PreferenceManager

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        PreferenceManager.initialize(this)

        if (PreferenceManager.isFirstTime()) {
            AddDataInDatabase(this@SplashActivity).addRecipeToDatabase()
            PreferenceManager.setFirstTime(false)
        }

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }

}

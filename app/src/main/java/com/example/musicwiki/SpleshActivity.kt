package com.example.musicwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SpleshActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splesh)
        Handler().postDelayed({
                              val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2000)

    }
}
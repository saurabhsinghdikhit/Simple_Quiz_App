package com.srb.a19mcal077_saurabh_set5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*

class dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        btncolor.setOnClickListener {
            val intent = Intent(this, ColorGame::class.java)
            startActivity(intent)
        }
        btnmaths.setOnClickListener {
            val intent = Intent(this, MathsGame::class.java)
            startActivity(intent)
        }
    }
}

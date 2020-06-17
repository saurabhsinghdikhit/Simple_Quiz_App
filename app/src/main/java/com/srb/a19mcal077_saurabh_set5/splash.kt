package com.srb.a19mcal077_saurabh_set5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        linearLayout.visibility= View.VISIBLE
        val aniFadein = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
        linearLayout.animation=aniFadein
        Handler().postDelayed(Runnable {
                val intent = Intent(this, dashboard::class.java)
                startActivity(intent)
                finish()
        }, 2500)
    }
}

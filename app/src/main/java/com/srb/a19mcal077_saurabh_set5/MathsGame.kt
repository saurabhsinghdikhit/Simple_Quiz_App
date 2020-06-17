package com.srb.a19mcal077_saurabh_set5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_maths_game.*
import kotlin.random.Random

class MathsGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths_game)
        makequestion()
        val arry = arrayOf("+","-","*","/")
        operator.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,arry)
        equals.setOnClickListener {
           var op1= opr1.text.toString().toInt()
            var op2= opr2.text.toString().toInt()
            var ans=0
            if(operator.selectedItem.toString().equals("+"))
                txtans.text=(op1 + op2).toString()
            if(operator.selectedItem.toString().equals("-"))
                txtans.text=(op1 - op2).toString()
            if(operator.selectedItem.toString().equals("*"))
                txtans.text=(op1 * op2).toString()
            if(operator.selectedItem.toString().equals("/")) {
                if (op2 != 0) {
                    txtans.text = (op1 / op2).toString()
                }
                else{
                    txtans.text="0"
                }
            }
            txtans.visibility= View.VISIBLE
            val anizoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom)
            txtans.animation=anizoom

        }
        btnnextm.setOnClickListener {
            makequestion()
            txtans.visibility=View.INVISIBLE
        }
        finishgame.setOnClickListener {
            val intent = Intent(this, dashboard::class.java)
            startActivity(intent)
            finish()
        }

    }
    fun makequestion(){
        var rnds = (0..9).random()
        opr1.text=rnds.toString()
        rnds = (0..9).random()
        opr2.text=rnds.toString()
    }
}

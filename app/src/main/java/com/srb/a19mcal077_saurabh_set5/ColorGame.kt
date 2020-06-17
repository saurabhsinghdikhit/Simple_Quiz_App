package com.srb.a19mcal077_saurabh_set5

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_color_game.*

class ColorGame : AppCompatActivity() {
    var queno=1
    var position=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_game)

        val color_image = arrayOf<String>("orange.jpg","blueberry.jpg","apple.jpg","grapes.jpg","mango.jpg")
        val op= arrayOf<String>("orange,blue,red,green","orange,blue,red,green","orange,blue,red,green","orange,blue,red,green","yellow,blue,red,green")
        val ans= arrayOf("orange","blue","red","green","yellow")
        totque.setText("Total Questions: ${color_image.size}")
        var totque=color_image.size-1
        makequestion(queno,color_image[position],op[position])
        var score=0

        rdColor!!.setOnCheckedChangeListener { group, checkedId ->
            var selRadioId=rdColor!!.checkedRadioButtonId
            var selRadio: RadioButton?=findViewById(selRadioId)
            if(selRadio!!.text.toString().trim().equals(ans[position].toString().trim())) {
                resultpic.visibility=View.VISIBLE
                resultpic.setImageResource(R.drawable.smily)
                val aniFadein = AnimationUtils.loadAnimation(applicationContext, R.anim.scale)
                resultpic.animation=aniFadein

            }else{
                resultpic.visibility=View.VISIBLE
                resultpic.setImageResource(R.drawable.tryagain)
                val aniFadein = AnimationUtils.loadAnimation(applicationContext, R.anim.scale)
                resultpic.animation=aniFadein
            }
        }

        btnnext.setOnClickListener {
            var selRadioId=rdColor!!.checkedRadioButtonId
            var selRadio: RadioButton?=findViewById(selRadioId)
            if(selRadio==null){
                Toast.makeText(this,"please select any option", Toast.LENGTH_SHORT).show()
            }
            else {
                if (position < totque) {
                    if(selRadio!!.text.toString().trim().equals(ans[position].toString().trim()))
                        score=score+1
                    position = position + 1
                    queno = queno + 1
                 //  rdColor!!.clearCheck()
                    resultpic.visibility=View.INVISIBLE
                    makequestion(queno,color_image[position],op[position])

                } else {
                    if(selRadio!!.text.toString().trim().equals(ans[position].toString().trim()))
                        score=score+1
                    var build = AlertDialog.Builder(this)
                    build.setMessage("Want to see the result")
                    build.setTitle("Quiz is Finished")
                    build.setPositiveButton("Yes",
                        DialogInterface.OnClickListener { dialog, which ->
                            var build1 = AlertDialog.Builder(this)
                            build1.setMessage("You have scored $score out of ${color_image.size}")
                            build1.setTitle("Your Score:-")
                            build1.setPositiveButton("Okay",
                                DialogInterface.OnClickListener { dialog, which ->
                                    startActivity(Intent(this,dashboard::class.java))
                                    finish()
                                })
                            build.setCancelable(false)
                            var dialog=build1.create()
                            dialog.show()

                        })
                    build.setNegativeButton("No",
                        DialogInterface.OnClickListener { dialog, which ->
                            Toast.makeText(this, "Quiz is Finished", Toast.LENGTH_SHORT).show()
                        })
                    build.setCancelable(false)
                    var dialog = build.create()
                    dialog.show()
                }

            }
        }
        btnprev.setOnClickListener{
            if(position>0) {
                position = position - 1
                queno=queno-1
                makequestion(queno,color_image[position],op[position])
            }
            else {
                Toast.makeText(this,"Already on 1st question", Toast.LENGTH_SHORT).show()
            }

        }

    }
    fun makequestion(que:Int,img:String,opt:String){
        var nm=img.substring(0,img.indexOf("."))
        val id = resources.getIdentifier(nm, "drawable", this.getPackageName())
        pic.setImageResource(id)
        var rt=opt.toString().split(",").toTypedArray()
        op1.setText(rt[0].toString())
        op2.setText(rt[1].toString())
        op3.setText(rt[2].toString())
        op4.setText(rt[3].toString())
    }
}

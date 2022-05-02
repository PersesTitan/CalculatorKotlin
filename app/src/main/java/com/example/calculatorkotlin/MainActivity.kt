package com.example.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var totalText : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number0 : Button = this.findViewById(R.id.number0)
        val number1 : Button = this.findViewById(R.id.number1)
        val number2 : Button = this.findViewById(R.id.number2)
        val number3 : Button = this.findViewById(R.id.number3)
        val number4 : Button = this.findViewById(R.id.number4)
        val number5 : Button = this.findViewById(R.id.number5)
        val number6 : Button = this.findViewById(R.id.number6)
        val number7 : Button = this.findViewById(R.id.number7)
        val number8 : Button = this.findViewById(R.id.number8)
        val number9 : Button = this.findViewById(R.id.number9)
        val off : Button = this.findViewById(R.id.off)
        val ac : Button = this.findViewById(R.id.ac)
        val na : Button = this.findViewById(R.id.na)
        val go : Button = this.findViewById(R.id.go)
        val ma : Button = this.findViewById(R.id.ma)
        val pl : Button = this.findViewById(R.id.pl)
        val eq : Button = this.findViewById(R.id.eq)
        val result : TextView = this.findViewById(R.id.result)

        result.text = ""

        val listener = View.OnClickListener { v ->
            when (v.id) {
                R.id.number0 -> totalText += 0
                R.id.number1 -> totalText += 1
                R.id.number2 -> totalText += 2
                R.id.number3 -> totalText += 3
                R.id.number4 -> totalText += 4
                R.id.number5 -> totalText += 5
                R.id.number6 -> totalText += 6
                R.id.number7 -> totalText += 7
                R.id.number8 -> totalText += 8
                R.id.number9 -> totalText += 9
                R.id.na -> totalText += "/"
                R.id.go -> totalText += "*"
                R.id.ma -> totalText += "-"
                R.id.pl -> totalText += "+"
                R.id.ac -> totalText = ""
                R.id.eq -> resultText()
                R.id.off -> finish()
            }

            result.text = totalText
        }

        number0.setOnClickListener(listener)
        number1.setOnClickListener(listener)
        number2.setOnClickListener(listener)
        number3.setOnClickListener(listener)
        number4.setOnClickListener(listener)
        number5.setOnClickListener(listener)
        number6.setOnClickListener(listener)
        number7.setOnClickListener(listener)
        number8.setOnClickListener(listener)
        number9.setOnClickListener(listener)
        ac.setOnClickListener(listener)
        off.setOnClickListener(listener)
        na.setOnClickListener(listener)
        go.setOnClickListener(listener)
        ma.setOnClickListener(listener)
        pl.setOnClickListener(listener)
        eq.setOnClickListener(listener)
    }

    private fun resultText() {
        val numbers : MutableList<String> = totalText.split("*", "/", "-", "+") as MutableList<String>
        val texts : MutableList<String> = totalText.split("[0-9]".toRegex()) as MutableList<String>
        numbers.removeAll(listOf(""))
        texts.removeAll(listOf(""))

        var total : Double = numbers[0].toDouble()
        for (i: Int in 0 until texts.size step(1)) {
            when (texts[i]) {
                "+" -> total += numbers[i+1].toDouble()
                "-" -> total -= numbers[i+1].toDouble()
                "*" -> total *= numbers[i+1].toDouble()
                "/" -> total /= numbers[i+1].toDouble()
            }
        }

        totalText = total.toString()
    }
}
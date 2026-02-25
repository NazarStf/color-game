package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout


import android.widget.TextView
import android.graphics.Color


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val t1 = findViewById<TextView>(R.id.t1)
        val t2 = findViewById<TextView>(R.id.t2)
        val t3 = findViewById<TextView>(R.id.t3)
        val t4 = findViewById<TextView>(R.id.t4)
        val t5 = findViewById<TextView>(R.id.t5)
        val t6 = findViewById<TextView>(R.id.t6)
        val t7 = findViewById<TextView>(R.id.t7)
        val t8 = findViewById<TextView>(R.id.t8)
        val t9 = findViewById<TextView>(R.id.t9)
        val t10 = findViewById<TextView>(R.id.t10)
        val t11 = findViewById<TextView>(R.id.t11)
        val t12 = findViewById<TextView>(R.id.t12)
        val t13 = findViewById<TextView>(R.id.t13)
        val t14 = findViewById<TextView>(R.id.t14)
        val t15 = findViewById<TextView>(R.id.t15)

        val allTextViews = listOf(t1,t2,t3,t4,t5,t6,t7,t8,t9, t10,t11,t12,t13,t14,t15)



        // Source - https://stackoverflow.com/a/45687695
        // ve)
        val mainContainer = findViewById<LinearLayout>(R.id.mainContainer)
        val colors = listOf(Color.RED, Color.GREEN, Color.YELLOW)
        for (i in 0 until mainContainer.childCount) {
            val row = mainContainer.getChildAt(i) as LinearLayout
            for (j in 0 until row.childCount) {
                val textView = row.getChildAt(j) as TextView
                textView.isClickable = true
                textView.isFocusable = true
                textView.setOnClickListener {
                    textView.setBackgroundColor(colors.random())
                }
            }

    }


    }
}
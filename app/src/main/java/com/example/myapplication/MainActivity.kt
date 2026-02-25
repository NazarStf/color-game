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

        // Source - https://stackoverflow.com/a/45687695
        // ve)
        val mainContainer = findViewById<LinearLayout>(R.id.mainContainer)

        for (i in 0 until mainContainer.childCount) {
            val row = mainContainer.getChildAt(i) as LinearLayout
            for (j in 0 until row.childCount) {
                var rnds = (0..2).random()
                val textView = row.getChildAt(i) as TextView
                if (rnds == 0) {
                    val colorV = "green"
                    textView.setBackgroundColor(Color.parseColor(colorV));
                }
                if (rnds == 1) {
                    val colorV = "red"
                    textView.setBackgroundColor(Color.parseColor(colorV));
                }
                if (rnds == 2) {
                    val colorV = "yellow"
                    textView.setBackgroundColor(Color.parseColor(colorV));
                }
            }
        }

    }
}
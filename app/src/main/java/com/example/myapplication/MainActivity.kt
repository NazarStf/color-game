package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.graphics.drawable.ColorDrawable
import android.widget.Toast

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

        fun checkColors(mainContainer: LinearLayout): Boolean {
            var firstColor: Int? = null

            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout
                for (j in 0 until row.childCount) {
                    val tv = row.getChildAt(j) as TextView
                    val bg = tv.background
                    if (bg is ColorDrawable) {
                        val color = bg.color
                        if (firstColor == null) firstColor = color
                        else if (color != firstColor)
                            return false
                    }
                }
            }
            val mainContainer = findViewById<LinearLayout>(R.id.mainContainer)
            val colors = listOf(Color.RED, Color.GREEN, Color.YELLOW)
            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout
                for (j in 0 until row.childCount) {
                    val textView = row.getChildAt(j) as TextView
                    textView.isClickable = true
                    textView.isFocusable = true
                    textView.setOnClickListener {
                        val newColor = colors.random()
                        textView.setBackgroundColor(newColor)

                        if (checkColors(mainContainer)) {
                            Toast.makeText(this, "All colors match!", Toast.LENGTH_SHORT).show()
                        }
                    }

                }



            }
            return true
        }
    }
}
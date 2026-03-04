package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

import android.widget.TextView
import android.graphics.Color
import org.w3c.dom.Text


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

        val mainContainer = findViewById<LinearLayout>(R.id.mainContainer)
        val levels = findViewById<LinearLayout>(R.id.levels)
        var selectedLevel = 0
        val colors = listOf(Color.RED, Color.GREEN, Color.YELLOW)

        fun randomizeColors() {
            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout
                for (j in 0 until row.childCount) {
                    val textView = row.getChildAt(j) as TextView
                    val newColor = colors.random()
                    textView.setBackgroundColor(newColor)

                }
            }

        }
        randomizeColors()

        fun checkColors(): Boolean {
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
            return true
        }

        fun checkColors1(): Boolean {

            var firstColor: Int? = null
            var secondColor: Int? = null
            var thirdColor: Int? = null

            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout

                for (j in 0 until row.childCount) {
                    val tv = row.getChildAt(j) as TextView
                    val bg = tv.background

                    if (bg is ColorDrawable) {
                        val color = bg.color

                        when (j) {
                            0 -> {
                                if (firstColor == null) firstColor = color
                                else if (color != firstColor) return false
                            }
                            1 -> {
                                if (secondColor == null) secondColor = color
                                else if (color != secondColor) return false
                            }
                            2 -> {
                                if (thirdColor == null) thirdColor = color
                                else if (color != thirdColor) return false
                            }
                        }
                    }
                }
            }

            return true
        }
        fun checkColors2(): Boolean {
            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout
                var hasRedInRow = false
                for (j in 0 until row.childCount) {
                    val tv = row.getChildAt(j) as TextView
                    val bg = tv.background
                    if (bg is ColorDrawable) {
                        if (bg.color == Color.RED) {
                            hasRedInRow = true
                            break
                        }
                    }
                }
                if (!hasRedInRow) {
                    return false
                }
            }

            return true
        }
        fun checkColors3(): Boolean {
            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout
                for (j in 0 until row.childCount) {
                    val tv = row.getChildAt(j) as TextView
                    val bg = tv.background
                    if (bg is ColorDrawable) {
                        val currentColor = bg.color
                        if (j < row.childCount - 1) {
                            val rightTv = (row.getChildAt(j + 1)as TextView).background
                            if (rightTv is ColorDrawable && rightTv.color == currentColor) {
                                return false
                            }
                        }
                        if (i < mainContainer.childCount - 1) {
                            val nextRow = (mainContainer.getChildAt(i + 1) as LinearLayout)
                            val bottomTv = (nextRow.getChildAt(j) as TextView).background
                            if (bottomTv is ColorDrawable && bottomTv.color == currentColor) {
                                return false
                            }
                        }
                    }
                }
            }

            return true
        }



        fun winner(){
            Toast.makeText(this, "All colors match!", Toast.LENGTH_SHORT).show()

            val builder = AlertDialog.Builder(this)
            builder.setMessage("Restart?")

            builder.setPositiveButton("Yes") { dialog, which ->
                randomizeColors()
            }
            builder.setNegativeButton("No") { dialog, which ->
                dialog.dismiss()
            }

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }



            for (i in 0 until mainContainer.childCount) {
                val row = mainContainer.getChildAt(i) as LinearLayout
                for (j in 0 until row.childCount) {
                    val textView = row.getChildAt(j) as TextView
                    textView.isClickable = true
                    textView.isFocusable = true
                    textView.setOnClickListener {
                        val newColor = colors.random()
                        textView.setBackgroundColor(newColor)
                        when (selectedLevel) {
                            0 -> if (checkColors()) winner()
                            1 -> if (checkColors1()) winner()
                            2 -> if (checkColors2()) winner()
                            3 -> if (checkColors3()) winner()
                        }

                }

            }
                for (j in 0 until levels.childCount) {
                    val levelView = levels.getChildAt(j) as TextView

                    levelView.setOnClickListener {
                        selectedLevel = j
                        Toast.makeText(this, "Level $selectedLevel selected", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
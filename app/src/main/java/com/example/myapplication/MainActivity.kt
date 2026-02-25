package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


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
// Posted by s1m0nw1, modified by community. See post 'Timeline' for change history
// Retrieved 2026-02-25, License - CC BY-SA 4.0


        // Source - https://stackoverflow.com/q/23517879
// Posted by user3274646, modified by community. See post 'Timeline' for change history
// Retrieved 2026-02-25, License - CC BY-SA 3.0
        val someView = findViewById<TextView>(R.id.t)
        someView.setBackgroundColor(Color.parseColor("#ffffff"));

        val rnds = (0..2).random() // generates random from 0 to 10 (inclusi
        // ve)
        if (rnds == 0) {
            val colorV = "green"
            someView.setBackgroundColor(Color.parseColor(colorV));
        }
        if (rnds == 1) {
            val colorV = "red"
            someView.setBackgroundColor(Color.parseColor(colorV));
        }
        if (rnds == 2) {
            val colorV = "yellow"
            someView.setBackgroundColor(Color.parseColor(colorV));
        }


    }
}
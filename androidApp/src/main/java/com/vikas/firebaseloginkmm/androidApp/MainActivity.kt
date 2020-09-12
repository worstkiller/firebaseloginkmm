package com.vikas.firebaseloginkmm.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vikas.firebaseloginkmm.shared.Greeting
import android.widget.TextView

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

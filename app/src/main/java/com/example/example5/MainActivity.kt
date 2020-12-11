package com.example.example5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity(), Communicator {

    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = intent.getStringExtra("login").toString()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer, BlankFragmentA.newInstance(name))
            commit()
        }
    }

    override fun passData(inputString: String) {
       this.supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer, BlankFragmentB.newInstance(inputString))
            addToBackStack("2")
            commit()
        }
    }
}
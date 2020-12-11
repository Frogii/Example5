package com.example.example5.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.example5.util.Communicator
import com.example.example5.R
import com.example.example5.util.Constants.Companion.LOGIN_STRING


class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            replace(
                R.id.frameContainer,
                BlankFragmentA.newInstance(intent.getStringExtra(LOGIN_STRING).toString()))
            commit()
        }
    }

    override fun passData(inputString: String) {
        this.supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameContainer, BlankFragmentB.newInstance(inputString))
            addToBackStack(null)
            commit()
        }
    }
}
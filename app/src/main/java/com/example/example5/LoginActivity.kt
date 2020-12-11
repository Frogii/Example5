package com.example.example5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    private var login = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {

            if (etLogin.text.isEmpty() || etPassword.text.isEmpty()) {
                Toast.makeText(this, "Enter the login/password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            login = etLogin.text.toString()

            GlobalScope.launch(Dispatchers.IO) {
                showProgress()
                delay(1500)
                hideProgress()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra("login", login)
                startActivity(intent)
            }
        }
    }

    private suspend fun showProgress() = withContext(Dispatchers.Main) {
        progressBar.visibility = VISIBLE
    }

    private suspend fun hideProgress() = withContext(Dispatchers.Main) {
        progressBar.visibility = GONE
    }

}
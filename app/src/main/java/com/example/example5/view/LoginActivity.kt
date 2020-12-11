package com.example.example5.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.example.example5.R
import com.example.example5.util.Constants.Companion.LOGIN_STRING
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {

            if (etLogin.text.isEmpty() || etPassword.text.isEmpty()) {
                Toast.makeText(this, "Enter the login/password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            GlobalScope.launch(Dispatchers.IO) {
                showProgress()
                delay(1500)
                hideProgress()
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(LOGIN_STRING, etLogin.text.toString())
                startActivity(intent)
                finish()
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
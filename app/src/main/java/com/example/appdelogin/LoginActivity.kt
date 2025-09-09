package com.example.appdelogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val name = editTextName.text.toString()

            if (name.isNotEmpty()) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USER_NAME", name)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, digite seu nome!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
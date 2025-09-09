package com.example.appdelogin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var textViewWelcome: TextView

    private var currentUserName: String? = null

    private val settingsActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val newName = data?.getStringExtra("NEW_NAME")

            if (newName != null && newName.isNotEmpty()) {
                currentUserName = newName
                textViewWelcome.text = "Bem-vindo(a), $currentUserName!"
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        textViewWelcome = findViewById(R.id.textViewWelcome)
        val buttonSettings = findViewById<Button>(R.id.buttonSettings)

        currentUserName = intent.getStringExtra("USER_NAME")

        textViewWelcome.text = "Bem-vindo(a), $currentUserName!"

        buttonSettings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)

            intent.putExtra("CURRENT_NAME", currentUserName)

            settingsActivityResultLauncher.launch(intent)
        }
    }
}
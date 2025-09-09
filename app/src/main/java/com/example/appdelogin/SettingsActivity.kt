package com.example.appdelogin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val editTextNewName = findViewById<EditText>(R.id.editTextNewName)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val currentName = intent.getStringExtra("CURRENT_NAME")
        editTextNewName.setText(currentName)

        buttonSave.setOnClickListener {
            val newName = editTextNewName.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("NEW_NAME", newName)

            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
    }
}
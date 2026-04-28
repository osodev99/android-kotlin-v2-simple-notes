package com.codebear.simpletakenotes.mvc_example

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codebear.simpletakenotes.R

class MVCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mvcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        showNotes()

        val etNote = findViewById<EditText>(R.id.etContent)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            val text = etNote.text.toString()
            NotesDb.notes.add(
                Note(
                    content = text,
                    id = NotesDb.notes.size + 1
                )
            )
            showNotes()
            etNote.text.clear()
        }


    }

    fun showNotes() {
        Log.e("TAG", "showNotes: ${NotesDb.notes}")
    }

    fun updateNote(id: Int, newContent: String) {
        // ... update logic
        showNotes()
    }

    fun deleteNote(id: Int) {
        // ... delete logic
        showNotes()
    }
}
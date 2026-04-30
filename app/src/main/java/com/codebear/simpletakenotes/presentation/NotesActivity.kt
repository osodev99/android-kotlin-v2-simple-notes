package com.codebear.simpletakenotes.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.codebear.simpletakenotes.data.NotesDatabase
import com.codebear.simpletakenotes.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private var canShowList = true

    private val resultForm = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data?.extras?.getString("data")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val notesAdapter = NotesAdapter(items = NotesDatabase().getFakeNotes())
        val llm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvNotes.adapter = notesAdapter
        binding.rvNotes.layoutManager = llm

        if (notesAdapter.items.isEmpty()) {
            hideList()
        } else {
            showList()
        }

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this,
                FormNoteActivity::class.java)
            resultForm.launch(intent)
        }

    }

    fun hideList() {
        binding.rvNotes.visibility = View.GONE
        binding.llMessage.visibility = View.VISIBLE
    }

    fun showList() {
        binding.rvNotes.visibility = View.VISIBLE
        binding.llMessage.visibility = View.GONE
    }
}
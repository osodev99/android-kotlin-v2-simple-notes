package com.codebear.simpletakenotes.presentation

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.codebear.simpletakenotes.data.NotesDatabase
import com.codebear.simpletakenotes.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private var canShowList = true

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

//        binding.fabAdd.setOnClickListener {
//            canShowList = !canShowList
//            if (canShowList) {
//                showList()
//            } else {
//                hideList()
//            }
//        }

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
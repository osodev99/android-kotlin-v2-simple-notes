package com.codebear.simpletakenotes.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.codebear.simpletakenotes.databinding.ActivityNotesBinding
import com.codebear.simpletakenotes.domain.models.NoteModel

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private var adapter: NotesAdapter? = null
    private val notes = mutableListOf<NoteModel>()

    private val resultForm = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                result.data?.extras?.getParcelable("data", NoteModel::class.java)
            } else {
                result.data?.extras?.getParcelable<NoteModel>("data")
            }

            if (data != null) {
                data.id = notes.size + 1
                Log.e("TAG", "toInsert: $data")
                adapter?.insertNote(data)
                if (adapter != null && adapter!!.items.isEmpty()) {
                    hideList()
                } else {
                    showList()
                }
            }
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

        adapter = NotesAdapter(items = notes)
        val llm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = llm

        if (adapter != null && adapter!!.items.isEmpty()) {
            hideList()
        } else {
            showList()
        }

        binding.fabAdd.setOnClickListener {
            val intent = Intent(
                this,
                FormNoteActivity::class.java
            )
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
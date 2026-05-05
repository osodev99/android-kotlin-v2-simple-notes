package com.codebear.simpletakenotes.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.codebear.simpletakenotes.databinding.ActivityNotesBinding
import com.codebear.simpletakenotes.domain.models.NoteModel

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private val vm by viewModels<NotesVM>()
    private var adapter: NotesAdapter? = null
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
                vm.insertNote(data)
                adapter?.insertNote(data)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        vm = ViewModelProvider.create(this)[NotesVM::class]
        enableEdgeToEdge()
        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vm.notesObs.observe(this) {
            if (it.isEmpty()) {
                hideList()
            } else {
                showList()
            }
        }

        adapter = NotesAdapter(items = vm.notes)
        val llm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvNotes.adapter = adapter
        binding.rvNotes.layoutManager = llm

        binding.fabAdd.setOnClickListener {
            val intent = Intent(
                this,
                FormNoteActivity::class.java
            )
            resultForm.launch(intent)
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putParcelableArray("notes", notes.toTypedArray())
//    }


//        val savedNotes =
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                savedInstanceState?.getParcelableArray("notes", NoteModel::class.java)
//            } else {
//                savedInstanceState?.getParcelableArray("notes")
//            }

    //        if (savedNotes != null) {
//            notes.addAll(0, (savedNotes as Array<NoteModel>).toMutableList())
//        }
    fun hideList() {
        binding.rvNotes.visibility = View.GONE
        binding.llMessage.visibility = View.VISIBLE
    }

    fun showList() {
        binding.rvNotes.visibility = View.VISIBLE
        binding.llMessage.visibility = View.GONE
    }
}
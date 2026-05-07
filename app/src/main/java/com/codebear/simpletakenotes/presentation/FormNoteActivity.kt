package com.codebear.simpletakenotes.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codebear.simpletakenotes.databinding.ActivityFormNoteBinding
import com.codebear.simpletakenotes.domain.models.NoteModel

class FormNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFormNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFormNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mArguments = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelable("data", NoteModel::class.java)
        } else {
            intent.extras?.getParcelable<NoteModel>("data")
        }
        setupUI(isUpdate = (mArguments != null), mArguments)

        binding.btnSaveNote.setOnClickListener {
            if (isValidForm()) {
                val title = binding.etTitle.text.toString()
                val content = binding.etContent.text.toString()

                val intent = Intent()
                intent.putExtra(
                    "data",
                    NoteModel(
                        title = title,
                        content = content,
                        createdAt = System.currentTimeMillis()
                    )
                )
                setResult(NotesActivity.RESULT_SAVE, intent)
                finish()
            }
        }

        binding.btnUpdate.setOnClickListener {
            if (isValidForm()) {
                val title = binding.etTitle.text.toString()
                val content = binding.etContent.text.toString()

                val intent = Intent()
                intent.putExtra(
                    "data",
                    NoteModel(
                        id = mArguments?.id,
                        title = title,
                        content = content,
                        createdAt = System.currentTimeMillis()
                    )
                )
                setResult(NotesActivity.RESULT_UPDATE, intent)
                finish()
            }
        }

        binding.btnDelete.setOnClickListener {
            if (isValidForm()) {
                val title = binding.etTitle.text.toString()
                val content = binding.etContent.text.toString()

                val intent = Intent()
                intent.putExtra(
                    "data",
                    NoteModel(
                        id = mArguments?.id,
                        title = title,
                        content = content,
                        createdAt = System.currentTimeMillis()
                    )
                )
                setResult(NotesActivity.RESULT_DELETE, intent)
                finish()
            }
        }
    }


    private fun setupUI(isUpdate: Boolean, noteModel: NoteModel?) {
        if (isUpdate) {
            binding.llUpdateButtons.visibility = View.VISIBLE
            binding.btnSaveNote.visibility = View.GONE
            binding.tvTitleForm.text = "Actualizacion"
            binding.etTitle.setText(noteModel?.title ?: "")
            binding.etContent.setText(noteModel?.content ?: "")
        } else {
            binding.llUpdateButtons.visibility = View.GONE
            binding.btnSaveNote.visibility = View.VISIBLE
            binding.tvTitleForm.text = "Registro"
        }
    }

    private fun isValidForm(): Boolean {
        val title = binding.etTitle.text.toString()
        val content = binding.etContent.text.toString()

        binding.tilTitle.error = if (title.isEmpty()) "Campo requerido" else null
        binding.tilContent.error = if (content.isEmpty()) "Campo requerido" else null

        return (title.isNotEmpty() && content.isNotEmpty())

    }
}
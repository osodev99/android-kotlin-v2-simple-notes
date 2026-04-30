package com.codebear.simpletakenotes.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codebear.simpletakenotes.databinding.ActivityFormNoteBinding

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

        val mArguments = intent.extras?.getInt("id")
        setupUI(isUpdate = (mArguments != null))

        binding.btnSaveNote.setOnClickListener {
            if (isValidForm()) {
                val intent = Intent()
                intent.putExtra(
                    "data",
                    "${binding.etTitle.text.toString()} - ${binding.etContent.text.toString()}"
                )
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        binding.btnUpdate.setOnClickListener {
            if (isValidForm()) {
                // update note
            }
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }


    private fun setupUI(isUpdate: Boolean) {
        if (isUpdate) {
            binding.llUpdateButtons.visibility = View.VISIBLE
            binding.btnSaveNote.visibility = View.GONE
            binding.tvTitleForm.text = "Actualizacion"
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
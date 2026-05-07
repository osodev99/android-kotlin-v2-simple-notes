package com.codebear.simpletakenotes.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.codebear.simpletakenotes.data.AppDatabase
import com.codebear.simpletakenotes.domain.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesVM(application: Application) : AndroidViewModel(application) {
    //    val notesObs = MutableLiveData<MutableList<NoteModel>>(mutableListOf())
    val notesObs = MutableStateFlow<List<NoteModel>>(emptyList())
    private val db = AppDatabase.getDb(application.baseContext)
    private val notesDao = db.notesDao()

    init {
        observeNotes()
    }

    fun insertNote(note: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            notesDao.insert(note)
        }
    }

    fun deleteNote(note: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            notesDao.deleteNotes(note)
        }
    }

    fun updateNote(note: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            notesDao.updateNote(note)
        }
    }

    private fun observeNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            notesDao.getAllNotes().collectLatest { list ->
                withContext(Dispatchers.Main) {
                    notesObs.value = list
                }
            }
        }
    }
}
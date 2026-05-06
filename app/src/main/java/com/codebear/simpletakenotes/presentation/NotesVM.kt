package com.codebear.simpletakenotes.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codebear.simpletakenotes.domain.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotesVM : ViewModel() {
    val notes = mutableListOf<NoteModel>()
    val notesObs = MutableLiveData<MutableList<NoteModel>>(mutableListOf())
    val nroObs = MutableLiveData<Int>()


    fun insertNote(note: NoteModel) {
        viewModelScope.launch(Dispatchers.IO) {
            fakeDelay()
            note.id = notes.size + 1
            notes.add(note)

            withContext(Dispatchers.Main) {
                notesObs.value = notes
                nroObs.value = notes.size
            }
        }
    }

    suspend fun fakeDelay() {
        delay(30000L)
    }
}
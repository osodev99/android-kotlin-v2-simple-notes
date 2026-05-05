package com.codebear.simpletakenotes.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codebear.simpletakenotes.domain.models.NoteModel

class NotesVM : ViewModel() {
    val notes = mutableListOf<NoteModel>()
    val notesObs = MutableLiveData<MutableList<NoteModel>>(mutableListOf())
    val nroObs = MutableLiveData<Int>()


    fun insertNote(note: NoteModel) {
        note.id = notes.size + 1
        notes.add(note)

        notesObs.value = notes
        nroObs.value = notes.size
    }
}
package com.codebear.simpletakenotes.mvc_example

class NotesDb {
    companion object {
        val notes: MutableList<Note> = mutableListOf()
    }
}

class Note(val id: Int, val content: String) {}
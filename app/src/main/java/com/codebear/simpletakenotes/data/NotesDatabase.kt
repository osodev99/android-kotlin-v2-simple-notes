package com.codebear.simpletakenotes.data

import com.codebear.simpletakenotes.domain.models.NoteModel
import java.util.Calendar
import java.util.Date

class NotesDatabase {

    private fun createDate(year: Int, month: Int, day: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, 0, 0, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        return calendar.time
    }

    fun getFakeNotes(): List<NoteModel> {
        val notes = listOf(

            NoteModel(
                id = 5,
                title = "Frase motivacional",
                content = "La constancia vence lo que la dicha no alcanza."
            )
        )
        return notes
    }
}
package com.codebear.simpletakenotes.domain.models

import java.util.Date

class NoteModel(
    val id: Int,
    val title: String,
    val content: String,
    val createdAt: Date
)
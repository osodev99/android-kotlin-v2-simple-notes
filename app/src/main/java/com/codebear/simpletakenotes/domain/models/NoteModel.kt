package com.codebear.simpletakenotes.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteModel(
    var id: Int? = null,
    val title: String,
    val content: String
) : Parcelable
package com.codebear.simpletakenotes.domain.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity()
@Parcelize
data class NoteModel(
    @PrimaryKey(autoGenerate = true) var id: Int? = null,
    val title: String,
    val content: String,
    val createdAt: Long
) : Parcelable
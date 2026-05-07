package com.codebear.simpletakenotes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.codebear.simpletakenotes.domain.models.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(vararg note: NoteModel)

    @Query("SELECT * FROM NoteModel")
//    suspend fun getAllNotes(): List<NoteModel>
    fun getAllNotes(): Flow<List<NoteModel>>

    @Query("SELECT * FROM NoteModel WHERE id = :idArg")
    suspend fun getNoteById(idArg: Int): NoteModel

    @Update()
    suspend fun updateNote(note: NoteModel)

    @Delete
    suspend fun deleteNotes(vararg users: NoteModel)
}
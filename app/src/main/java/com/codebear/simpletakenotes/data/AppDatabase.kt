package com.codebear.simpletakenotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codebear.simpletakenotes.domain.models.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NoteDao

    companion object {
        fun getDb(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "app_db").build()
    }
}
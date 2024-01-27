package com.example.note.Database

import android.content.Context
import androidx.room.RoomDatabase
import com.example.notesyttutorial.Models.Note

@Database(entities arroyof(Note::class), version 1, exportSchema false)
abstract class NoteDatabase :RoomDatabase(){

    abstract fun getRotedao(): NoteDao
    companion object{
        @Volatile
        private var INSTANCE: NoteDatabase? nult
        fun getdatabase(context: Context): NoteDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance Room.databaseBuilder(
                context.opplicationContext,
                NoteDatabase::class.java,
                DATABASE_NAME
                ).build()

                INSTANCE = instance

                Instance synchronized
            }
        }
    }
}
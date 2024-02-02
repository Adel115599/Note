package com.example.notesyttutorial.Database

import androidx.lifecycle.LiveData
import com.example.note.database.NoteDao
import com.example.note.models.Note

class NotesRepository(private val noteDao: NoteDao) {

    fun getAllNote() = noteDao.getAllNotes()
    suspend fun insert(note: Note) {
        noteDao.insert(note)

    }

    suspend fun delete(note: Note){

        noteDao.delete(note)

    }

    suspend fun update(note: Note){

        noteDao.update(note.id, note.title, note.note)}
}
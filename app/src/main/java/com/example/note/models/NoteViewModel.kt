package com.example.note.models

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.note.database.NoteDatabase
import com.example.notesyttutorial.Database.NotesRepository
import kotlinx.coroutines.Dispatchers


class NoteViewModel(application: Context): ViewModel() {

    private val repository: NotesRepository

    val allnotes: LiveData<List<Note>>

    init {

        val dao = NoteDatabase.getInstance(application).noteDao()

        repository = NotesRepository(dao)

        allnotes = repository.getAllNote()
    }

    suspend fun deleteNote(note: Note) = repository.delete(note)

    suspend fun insertNote(note: Note) = repository.insert(note)

    suspend fun updateNote(note: Note) = repository.update(note)
}


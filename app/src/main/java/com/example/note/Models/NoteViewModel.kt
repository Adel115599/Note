package com.example.note.Models

import kotlinx.coroutines.Dispatchers


class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NotesRepository

    val allnotes: LiveData<List<List<Note>>

    init {

        val dao = NoteDatabase.getDatabase(application).getNoteDao()

        repository = NotesRepository(dao)

        allnotes = repository.allNotes
    }

    fun deleteNote(note: Note) = viewModelScope.Lounch(Dispatchers.IO) {
        this: CoroutineScope

        repository.delete(note)

    }

    fun insertNote(note: Note) = viewModelScope.Launch(Dispatchers.IO) {
        this :CommutingScope

        repository.insert(note)
    }

    fun updateNote(note: Note) = ViewModelScope.Launch(Dispatchers.IO) {
        this :CoroutineScope
        repository.update(note)
    }
}


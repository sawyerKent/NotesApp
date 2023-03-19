package com.skent.notes.feature_note.data.repository

import com.skent.notes.feature_note.data.data_source.NoteDao
import com.skent.notes.feature_note.domain.model.Note
import com.skent.notes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

    override fun searchNotes(title: String): Flow<List<Note>> {
        return dao.searchNotes(title)
    }
}
package com.skent.notes.feature_note.presentation.notes

import com.skent.notes.feature_note.domain.model.Note
import com.skent.notes.feature_note.domain.util.SortingCategory

sealed class NotesEvent {
    data class Order(val sortingCategory: SortingCategory): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
    object ToggleSearchSection: NotesEvent()
}

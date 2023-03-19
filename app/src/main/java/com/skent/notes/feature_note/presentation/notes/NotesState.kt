package com.skent.notes.feature_note.presentation.notes

import com.skent.notes.feature_note.domain.model.Note
import com.skent.notes.feature_note.domain.util.SortingCategory
import com.skent.notes.feature_note.domain.util.OrderArrangement

data class NotesState(
    val notes: List<Note> = emptyList(),
    val sortingCategory: SortingCategory = SortingCategory.Date(OrderArrangement.Descending),
    val isOrderSectionVisible: Boolean = false,
    val isSearchSectionVisible: Boolean = false
)

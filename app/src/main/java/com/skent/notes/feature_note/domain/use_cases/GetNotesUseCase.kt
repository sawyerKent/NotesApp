package com.skent.notes.feature_note.domain.use_cases

import com.skent.notes.feature_note.domain.model.Note
import com.skent.notes.feature_note.domain.repository.NoteRepository
import com.skent.notes.feature_note.domain.util.SortingCategory
import com.skent.notes.feature_note.domain.util.OrderArrangement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(
        sortingCategory: SortingCategory
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(sortingCategory.orderArrangement) {
                is OrderArrangement.Ascending -> {
                    when(sortingCategory) {
                        is SortingCategory.Title -> notes.sortedBy { it.title.lowercase() }
                        is SortingCategory.Date -> notes.sortedBy { it.timestamp }
                    }
                }
                is OrderArrangement.Descending -> {
                    when(sortingCategory) {
                        is SortingCategory.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is SortingCategory.Date -> notes.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}

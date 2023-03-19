package com.skent.notes.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skent.notes.feature_note.domain.model.Note
import com.skent.notes.feature_note.domain.use_cases.NoteUseCases
import com.skent.notes.feature_note.domain.util.SortingCategory
import com.skent.notes.feature_note.domain.util.OrderArrangement
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    init {
        getNotes(SortingCategory.Date(OrderArrangement.Descending))
    }

    fun onEvent(event: NotesEvent) {
        when (event) {
            is NotesEvent.Order -> {
                if (state.value.sortingCategory::class == event.sortingCategory::class &&
                    state.value.sortingCategory.orderArrangement == event.sortingCategory.orderArrangement
                ) {
                    return
                }
                getNotes(event.sortingCategory)
            }
            is NotesEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }
            is NotesEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
            is NotesEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
            is NotesEvent.ToggleSearchSection -> {
                _state.value = state.value.copy(
                    isSearchSectionVisible = !state.value.isSearchSectionVisible
                )
            }
        }
    }

    private fun getNotes(sortingCategory: SortingCategory) {
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getNotes(sortingCategory)
            .onEach { notes ->
                _state.value = state.value.copy(
                    notes = notes,
                    sortingCategory = sortingCategory
                )
            }
            .launchIn(viewModelScope)
    }
}



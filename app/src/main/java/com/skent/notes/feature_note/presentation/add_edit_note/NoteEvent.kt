package com.skent.notes.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState

sealed class NoteEvent{
    data class EnteredTitle(val value: String): NoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState): NoteEvent()
    data class EnteredContent(val value: String): NoteEvent()
    data class ChangeContentFocus(val focusState: FocusState): NoteEvent()
    object SaveNote: NoteEvent()
}


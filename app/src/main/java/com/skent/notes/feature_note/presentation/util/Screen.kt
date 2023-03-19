package com.skent.notes.feature_note.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object EditNoteScreen: Screen("add_edit_note_screen")
    object AddNoteScreen: Screen("add_note_screen")
}

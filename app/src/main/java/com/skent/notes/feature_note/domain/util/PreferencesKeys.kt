package com.skent.notes.feature_note.domain.util


import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val TITLE = stringPreferencesKey("title")
    val CONTENT = stringPreferencesKey("body")
}

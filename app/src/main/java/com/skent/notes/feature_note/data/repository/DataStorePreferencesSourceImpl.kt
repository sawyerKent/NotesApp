package com.skent.notes.feature_note.data.repository

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.skent.notes.feature_note.domain.repository.DataStorePreferencesSource
import com.skent.notes.feature_note.domain.util.Constants
import com.skent.notes.feature_note.domain.util.PreferencesKeys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(
    name = Constants.PREFERENCES
)

class DataStorePreferencesSourceImpl(private val context: Context) : DataStorePreferencesSource {
    override fun getPreferencesTitle(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.TITLE] ?: ""
        }
    }

    override fun getPreferencesContent(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.CONTENT] ?: ""
        }
    }

    override suspend fun setPreferencesTitle(title: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.TITLE] = title
        }
    }

    override suspend fun setPreferencesContent(body: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.CONTENT] = body
        }
    }
}


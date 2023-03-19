package com.skent.notes.feature_note.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStorePreferencesSource {
    fun getPreferencesTitle(): Flow<String>
    fun getPreferencesContent(): Flow<String>
    suspend fun setPreferencesTitle(title: String)
    suspend fun setPreferencesContent(body: String)
}




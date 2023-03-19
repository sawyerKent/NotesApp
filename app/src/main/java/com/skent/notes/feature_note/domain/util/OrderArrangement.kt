package com.skent.notes.feature_note.domain.util

sealed class OrderArrangement {
    object Ascending: OrderArrangement()
    object Descending: OrderArrangement()
}

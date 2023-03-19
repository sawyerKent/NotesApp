package com.skent.notes.feature_note.domain.util

sealed class SortingCategory(val orderArrangement: OrderArrangement) {
    class Title(orderArrangement: OrderArrangement): SortingCategory(orderArrangement)
    class Date(orderArrangement: OrderArrangement): SortingCategory(orderArrangement)

    fun copy(orderArrangement: OrderArrangement): SortingCategory {
        return when(this) {
            is Title -> Title(orderArrangement)
            is Date -> Date(orderArrangement)
        }
    }
}

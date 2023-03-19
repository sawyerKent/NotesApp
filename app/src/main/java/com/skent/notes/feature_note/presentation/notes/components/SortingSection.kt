package com.skent.notes.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skent.notes.feature_note.domain.util.SortingCategory
import com.skent.notes.feature_note.domain.util.OrderArrangement

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    sortingCategory: SortingCategory = SortingCategory.Date(OrderArrangement.Descending),
    onOrderChange: (SortingCategory) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = sortingCategory is SortingCategory.Title,
                onSelect = { onOrderChange(SortingCategory.Title(sortingCategory.orderArrangement)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = sortingCategory is SortingCategory.Date,
                onSelect = { onOrderChange(SortingCategory.Date(sortingCategory.orderArrangement)).also {

                } }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = sortingCategory.orderArrangement is OrderArrangement.Ascending,
                onSelect = {
                    onOrderChange(sortingCategory.copy(OrderArrangement.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = sortingCategory.orderArrangement is OrderArrangement.Descending,
                onSelect = {
                    onOrderChange(sortingCategory.copy(OrderArrangement.Descending))
                }
            )
        }
    }
}
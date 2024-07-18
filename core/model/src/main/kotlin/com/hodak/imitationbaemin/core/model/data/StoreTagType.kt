package com.hodak.imitationbaemin.core.model.data

import androidx.compose.ui.graphics.Color

enum class StoreTagType(
    val containerColor: Color,
    val contentColor: Color,
) {
    ECONOMY_DELIVERY(
        contentColor = Color.Unspecified,
        containerColor = Color.Transparent,
    ),
    SINGLE_DELIVERY(
        contentColor = Color.Unspecified,
        containerColor = Color.Transparent,
    ),
    NEW(
        contentColor = Color(0xFFC15996),
        containerColor = Color(0xFFFCEFF8),
    ),
    NORMAL(
        contentColor = Color(0xFF494949),
        containerColor = Color(0xFFF5F5F5),
    ),
}
package com.hodak.imitationbaemin.core.designsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.PersonOutline
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings

object HoIcons {
    val Add = Icons.Rounded.Add
    val ArrowBack = Icons.AutoMirrored.Rounded.ArrowBack
    val Check = Icons.Rounded.Check
    val Close = Icons.Rounded.Close
    val PersonOutline = Icons.Rounded.PersonOutline
    val Search = Icons.Rounded.Search
    val Settings = Icons.Rounded.Settings
    val Timer = Icons.Rounded.AccessTime
    val MoreVert = Icons.Default.MoreVert
}

sealed interface Icon {
    data class DrawableResourceIcon(@DrawableRes val resourceId: Int) : Icon
}
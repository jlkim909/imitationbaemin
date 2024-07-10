package com.hodak.imitationbaemin.core.designsystem.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@Composable
fun HoIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconColor: Color,
    icon: @Composable () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = iconColor
        ),
    ) {
        icon()
    }
}

@ThemePreviews
@Composable
fun HoIconButtonPreview() {
    HoTheme {
        HoIconButton(
            onClick = { },
            icon = {
                Icon(
                    imageVector = HoIcons.Notifications,
                    contentDescription = null
                )
            },
            iconColor = MaterialTheme.colorScheme.surface
        )
    }
}
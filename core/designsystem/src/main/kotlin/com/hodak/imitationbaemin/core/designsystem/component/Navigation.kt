package com.hodak.imitationbaemin.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.R
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@Composable
fun RowScope.HoNavigationBarItem(
    onClick: () -> Unit,
    iconPainter: Painter,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = label,
            modifier = Modifier
                .clickable(
                    enabled = enabled,
                    onClick = onClick,
                    role = Role.Button
                )
                .size(24.dp)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Composable
fun HoNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = Color(0xFF7E7F81),
        tonalElevation = 4.dp,
        content = content
    )
}

@Preview
@Composable
private fun HoNavigationBarPreview() {
    val items = listOf("검색", "장보기·쇼핑", "찜", "주문내역", "my배민")
    val icons = listOf(
        R.drawable.ic_bottom_bar_search,
        R.drawable.ic_bottom_bar_shopping,
        R.drawable.ic_bottom_bar_bookmark,
        R.drawable.ic_bottom_bar_history,
        R.drawable.ic_bottom_bar_my,
    )
    HoTheme {
        HoNavigationBar(
            modifier = Modifier.clip(
                RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            )
        ) {
            items.forEachIndexed { idx, item ->
                HoNavigationBarItem(
                    onClick = {},
                    iconPainter = painterResource(id = icons[idx]),
                    label = item,
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}
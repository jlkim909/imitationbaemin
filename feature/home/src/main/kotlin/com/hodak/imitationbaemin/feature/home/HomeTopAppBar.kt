package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.component.HoIconButton
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeTopAppBar(
    address: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    text = address,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.surface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.widthIn(max = 220.dp)
                )
                Icon(
                    imageVector = HoIcons.ArrowDropDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface,
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        actions = {
            HoIconButton(
                modifier = Modifier.size(36.dp),
                onClick = {},
                iconColor = MaterialTheme.colorScheme.surface,
                icon = {
                    Icon(
                        imageVector = HoIcons.GridView,
                        contentDescription = null,
                    )
                }
            )
            HoIconButton(
                modifier = Modifier.size(36.dp),
                onClick = {},
                iconColor = MaterialTheme.colorScheme.surface,
                icon = {
                    Icon(
                        imageVector = HoIcons.Notifications,
                        contentDescription = null,
                    )
                }
            )
            HoIconButton(
                modifier = Modifier.size(36.dp),
                onClick = {},
                iconColor = MaterialTheme.colorScheme.surface,
                icon = {
                    Icon(
                        imageVector = HoIcons.ShoppingCart,
                        contentDescription = null
                    )
                }
            )
        },
    )
}

@Preview("Home Top App Bar")
@Composable
private fun HomeTopAppBarPreview(){
    HoTheme {
        HomeTopAppBar(
            address = "전북 전주시 덕진구 모래내8길 34"
        )
    }
}
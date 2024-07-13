package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

internal fun LazyStaggeredGridScope.searchFood(
    text:String,
    onClick: () -> Unit,
) {
    item(span = StaggeredGridItemSpan.FullLine, contentType = "searchFood") {
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp,
                    )
                )
                .background(MaterialTheme.colorScheme.primary)
        ) {
            ElevatedButton(
                onClick = onClick,
                shape = RectangleShape,
                contentPadding = PaddingValues(12.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 0.dp,
                        start = 12.dp,
                        end = 12.dp,
                        bottom = 12.dp
                    ),
            ) {
                Icon(
                    imageVector = HoIcons.Search,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(top = 4.dp)
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = text,
                    color = Color.Black.copy(alpha = 0.5f),
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(Modifier.weight(1f))
            }
        }
    }
}

@Preview
@Composable
private fun SearchFoodPreview() {
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            searchFood(
                text = "팟타이 나와라 뚝딱!!",
                onClick = {}
            )
        }
    }
}
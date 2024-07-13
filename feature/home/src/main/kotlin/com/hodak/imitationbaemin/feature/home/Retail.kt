package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

internal fun LazyStaggeredGridScope.retail(
    modifier: Modifier = Modifier
) {
    val retails = listOf(
        RetailItemData(
            title = "가게배달",
            content = "가게에서\n자체 배달",
            imageRes = R.drawable.img_retail_delivery,
        ),
        RetailItemData(
            title = "장보기·쇼핑",
            content = "편의점부터\n마트까지",
            imageRes = R.drawable.img_retail_shopping,
        ),
        RetailItemData(
            title = "대용량특가",
            content = "많이 살수록\n저렴하죠",
            imageRes = R.drawable.img_retail_sale,
        ),
    )
    item(span = StaggeredGridItemSpan.FullLine, contentType = "retail") {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier
                .fillMaxWidth()
        ) {
            retails.forEach { retail ->
                RetailItem(
                    item = retail,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun RetailItem(
    item: RetailItemData,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        modifier = modifier.aspectRatio(1f)
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(top = 12.dp, start = 12.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = item.content,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 2,
                modifier = Modifier
                    .align(Alignment.CenterStart)
            )
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = null,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
        }
    }
}

private data class RetailItemData(
    val title: String,
    val content: String,
    val imageRes: Int,
)

@Preview
@Composable
private fun RetailPreview() {
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            retail()
        }
    }
}
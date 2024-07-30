package com.hodak.imitationbaemin.feature.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hodak.imitationbaemin.core.designsystem.component.HighlightedText
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme
import com.hodak.imitationbaemin.core.designsystem.theme.hannaPro

internal fun LazyStaggeredGridScope.baeminDelivery(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    item(span = StaggeredGridItemSpan.FullLine, contentType = "baeminDelivery") {
        ElevatedCard(
            onClick = onClick,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            modifier = modifier
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(
                        text = "배민배달",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontFamily = hannaPro
                        ),
                    )
                    Spacer(Modifier.width(8.dp))
                    HighlightedText(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append("알뜰·한집")
                            }
                            append(" 알뜰배달팁 0원")
                        },
                        highlightedText = "알뜰·한집",
                        style = MaterialTheme.typography.labelMedium,
                    )
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = HoIcons.ArrowBackIosNew,
                        contentDescription = null,
                        modifier = Modifier
                            .rotate(180f)
                            .size(16.dp)
                    )
                }
                Spacer(Modifier.height(4.dp))
                FoodCategoryGrid()
            }
        }
    }
}

@Composable
private fun FoodCategoryGrid(
    modifier: Modifier = Modifier,
    row: Int = 2,
    column: Int = 5,
) {
    val items = listOf(
        FoodImageButtonData(
            R.drawable.ic_food_category_japanese_food,
            "돈까스·회",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_pizza,
            "피자",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_chinese_food,
            "중식",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_chicken,
            "치킨",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_burger,
            "버거",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_cupcake,
            "카페·디저트",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_school_food,
            "분식",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_starbucks,
            "스타벅스",
            Color(0xFF1F3B34)
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_zflip,
            "삼성스토어",
            MaterialTheme.colorScheme.surface
        ),
        FoodImageButtonData(
            R.drawable.ic_food_category_gs25,
            "GS25",
            Color(0xFF007AFF)
        ),
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        repeat(row) { rowIndex ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                repeat(column) { columnIndex ->
                    val currentIdx = rowIndex * column + columnIndex
                    if (currentIdx < items.size) {
                        FoodImageButton(
                            imageRes = items[currentIdx].imageRes,
                            label = items[currentIdx].label,
                            containerColor = items[currentIdx].containerColor,
                            modifier = Modifier.weight(1f)
                        )
                    } else {
                        Spacer(Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
private fun FoodImageButton(
    @DrawableRes imageRes: Int,
    label: String,
    modifier: Modifier = Modifier,
    containerColor: Color?,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
                .background(
                    color = containerColor ?: MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(40)
                )
                .aspectRatio(1f)
                .padding(8.dp)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview
@Composable
private fun BaeminDeliveryPreview() {
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            baeminDelivery(
                onClick = {}
            )
        }
    }
}
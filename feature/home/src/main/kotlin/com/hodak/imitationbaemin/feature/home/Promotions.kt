package com.hodak.imitationbaemin.feature.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

internal fun LazyStaggeredGridScope.promotions(
    modifier: Modifier = Modifier
) {
    val footImageButtonItems = listOf(
        FoodImageButtonData(
            R.drawable.ic_promotions_packaging,
            "포장",
            null
        ),
        FoodImageButtonData(
            R.drawable.ic_promotions_nation_food,
            "전국별미",
            null
        ),
        FoodImageButtonData(
            R.drawable.ic_promotions_gift,
            "선물하기",
            null
        ),
        FoodImageButtonData(
            R.drawable.ic_promotions_point,
            "포인트 모으기",
            null
        ),
    )
    item(span = StaggeredGridItemSpan.FullLine, contentType = "promotions") {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            shape = RectangleShape,
            border = BorderStroke(width = 0.5.dp, MaterialTheme.colorScheme.surface),
            modifier = modifier,
        ) {
            TopBorder()
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                footImageButtonItems.forEach { item ->
                    FoodImageButton(
                        imageRes = item.imageRes,
                        label = item.label,
                    )
                }
            }
        }
    }
}

@Composable
private fun TopBorder(){
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
    ) {
        val lineLength = size.width
        val numberOfDots = 50
        val dotSpacing = lineLength / (numberOfDots * 2) // spacing between the dots
        val dotRadius = 2.dp.toPx() // radius of the dots

        for (i in 0 until numberOfDots) {
            val x = i * dotSpacing * 2 + dotSpacing
            drawArc(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFFF5F5F5), Color(0xFFD7D7D7)),
                    startY = 0f,
                    endY = 16.dp.value,
                ),
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(x = x, y = -4.dp.value),
                size = Size(dotRadius * 2, dotRadius * 2),
            )
        }
    }
}
@Composable
private fun FoodImageButton(
    @DrawableRes imageRes: Int,
    label: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color(0xFFE7E8EA),
                    shape = RoundedCornerShape(40)
                )
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(40)
                )
                .padding(8.dp)
                .size(52.dp)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Preview
@Composable
private fun PromotionsPreview() {
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            promotions()
        }
    }
}
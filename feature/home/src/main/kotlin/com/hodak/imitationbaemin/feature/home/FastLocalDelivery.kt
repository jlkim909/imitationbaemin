package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme
import com.hodak.imitationbaemin.core.model.data.StoreResource
import com.hodak.imitationbaemin.core.model.data.StoreTagData
import com.hodak.imitationbaemin.core.model.data.StoreTagType
import com.hodak.imitationbaemin.core.ui.StoreResourceItem

internal fun LazyStaggeredGridScope.fastLocalDelivery(
    storeItems: List<StoreResource>
) {
    item(span = StaggeredGridItemSpan.FullLine, contentType = "fastLocalDelivery") {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            Header(
                onClickAdInfo = {}
            )
            LazyRow(
                contentPadding = PaddingValues(top = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(storeItems) { storeResource ->
                    StoreResourceItem(
                        storeResource = storeResource
                    )
                }
            }
        }
    }
}

@Composable
private fun Header(
    onClickAdInfo: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "우리 동네 빠른 배달",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.width(2.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    onClick = onClickAdInfo,
                )
        ) {
            val contentColor = Color(0xFF818181)
            Text(
                text = "광고",
                style = MaterialTheme.typography.labelMedium,
                color = contentColor
            )
            Icon(
                imageVector = HoIcons.Info,
                tint = contentColor,
                contentDescription = null,
                modifier = Modifier.size(12.dp)
            )
        }
    }
}

@Preview
@Composable
private fun FastLocalDeliveryPreview() {
    val items = listOf(
        StoreResource(
            name = "BHC 전주인후점",
            thumbnailRes = R.drawable.img_store_thumbnail_bhc,
            rating = 4.9f,
            deliveryMinTip = 1500,
            deliveryMaxTip = 3400,
            deliveryMinTime = 18,
            deliveryMaxTime = 35,
            couponText = "",
            tags = listOf(
                StoreTagData(StoreTagType.ECONOMY_DELIVERY),
                StoreTagData(StoreTagType.SINGLE_DELIVERY),
                StoreTagData(StoreTagType.NORMAL, "포장가능"),
                StoreTagData(StoreTagType.NEW, "신규"),
            ),
        ),
        StoreResource(
            name = "배스킨라빈스 전주백제대로점",
            thumbnailRes = R.drawable.img_store_thumbnail_baskinrobbins,
            rating = 4.8f,
            enabledCoupon = true,
            deliveryMinTip = 300,
            deliveryMaxTip = 4000,
            deliveryMinTime = 11,
            deliveryMaxTime = 29,
            couponText = "1,000원 첫주문 할인",
            tags = listOf(
                StoreTagData(StoreTagType.ECONOMY_DELIVERY),
                StoreTagData(StoreTagType.SINGLE_DELIVERY),
            ),
        ),
        StoreResource(
            name = "백종원의 빽보이피자 전주인후점",
            thumbnailRes = R.drawable.img_store_thumbnail_paikboy,
            rating = 4.9f,
            deliveryMinTip = 0,
            deliveryMaxTip = 2400,
            deliveryMinTime = 16,
            deliveryMaxTime = 32,
            couponText = "",
            tags = listOf(
                StoreTagData(StoreTagType.ECONOMY_DELIVERY),
                StoreTagData(StoreTagType.SINGLE_DELIVERY),
            ),
        ),
        StoreResource(
            name = "피자나라치킨공주 전주금암점",
            thumbnailRes = R.drawable.img_store_thumbnail_pizzaandchicken,
            rating = 4.8f,
            deliveryMinTip = 0,
            deliveryMaxTip = 3400,
            deliveryMinTime = 16,
            deliveryMaxTime = 31,
            couponText = "",
            tags = listOf(
                StoreTagData(StoreTagType.ECONOMY_DELIVERY),
                StoreTagData(StoreTagType.SINGLE_DELIVERY),
            ),
        ),
    )
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            fastLocalDelivery(items)
        }
    }
}
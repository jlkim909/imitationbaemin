package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme
import com.hodak.imitationbaemin.core.model.data.StoreResource
import com.hodak.imitationbaemin.core.model.data.StoreTagData
import com.hodak.imitationbaemin.core.model.data.StoreTagType
import com.hodak.imitationbaemin.core.ui.StoreResourceItem

internal fun LazyStaggeredGridScope.lastOrder(
    storeItems: List<StoreResource>,
    modifier:Modifier = Modifier
) {
    item(span = StaggeredGridItemSpan.FullLine, contentType = "lastOrder") {
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            LastOrderHeader(
                onClickAdInfo = {},
                onClickOrderHistory = {},
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
            Spacer(Modifier.height(12.dp))
            LastOrderLinkBanner()
        }
    }
}

@Composable
private fun LastOrderHeader(
    onClickAdInfo: () -> Unit,
    onClickOrderHistory: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "최근에 주문했어요",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.width(2.dp))
        Icon(
            imageVector = HoIcons.Info,
            tint = Color(0xFF818181),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)

                .clickable(
                    onClick = onClickAdInfo,
                )
        )
        Spacer(Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable(
                    onClick = onClickOrderHistory
                )
        ) {
            Text(
                text = "주문내역 보기",
                style = MaterialTheme.typography.labelMedium,
            )
            Spacer(Modifier.width(2.dp))
            Icon(
                imageVector = HoIcons.ArrowBackIosNew,
                contentDescription = null,
                modifier = Modifier
                    .rotate(180f)
                    .size(12.dp)
            )
        }
    }
}

@Composable
private fun LastOrderLinkBanner(){
    Card(
        shape = RoundedCornerShape(12.dp),
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_last_order_banner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun LastOrderPreview() {
    val items = listOf(
        StoreResource(
            name = "동대문엽기떡볶이 전북대점",
            thumbnailRes = R.drawable.img_store_thumbnail_yupdduk,
            rating = 4.9f,
            deliveryMinTip = 0,
            deliveryMaxTip = 2000,
            deliveryMinTime = 40,
            deliveryMaxTime = 55,
            couponText = "",
            tags = listOf(
                StoreTagData(StoreTagType.NORMAL, "포장가능"),
            ),
        ),
        StoreResource(
            name = "충만치킨 호성점",
            thumbnailRes = R.drawable.img_store_thumbnail_choongman,
            rating = 4.8f,
            deliveryMinTip = 2310,
            deliveryMaxTip = 4710,
            deliveryMinTime = 22,
            deliveryMaxTime = 37,
            couponText = "",
            tags = listOf(
                StoreTagData(StoreTagType.SINGLE_DELIVERY),
            ),
        ),
    )
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            lastOrder(items)
        }
    }
}
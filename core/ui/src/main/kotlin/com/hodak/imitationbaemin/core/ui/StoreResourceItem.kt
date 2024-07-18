package com.hodak.imitationbaemin.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.component.EconomyDeliveryTag
import com.hodak.imitationbaemin.core.designsystem.component.HighlightedText
import com.hodak.imitationbaemin.core.designsystem.component.SingleDeliveryTag
import com.hodak.imitationbaemin.core.designsystem.component.StoreTag
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@Composable
fun StoreResourceItem(
    storeResource: StoreResource,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(140.dp)
    ) {
        StoreThumbnail(
            thumbnail = painterResource(id = storeResource.thumbnailRes),
            enabledCoupon = storeResource.enabledCoupon,
            couponText = storeResource.couponText,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.height(8.dp))
        StoreHeader(
            name = storeResource.name,
            rating = storeResource.rating,
        )
        Spacer(Modifier.height(4.dp))
        StoreDeliveryInfo(
            deliveryMinTime = storeResource.deliveryMinTime,
            deliveryMaxTime = storeResource.deliveryMaxTime,
            deliveryMinTip = storeResource.deliveryMinTip,
            deliveryMaxTip = storeResource.deliveryMaxTip,
        )
        Spacer(Modifier.height(4.dp))
        StoreTags(
            tags = storeResource.tags,
            modifier = Modifier.height(40.dp)
        )
    }
}

@Composable
private fun StoreThumbnail(
    thumbnail: Painter,
    modifier: Modifier = Modifier,
    enabledCoupon: Boolean = false,
    couponText: String = "",
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = thumbnail,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
        if (enabledCoupon) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                    .background(Color(0xFF6850FE))
                    .padding(4.dp)
            ) {
                Text(
                    text = couponText,
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
private fun StoreHeader(
    name:String,
    rating: Float,
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(1f)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = HoIcons.Star,
                contentDescription = null,
                tint = Color(0xFFFDC401),
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = "$rating",
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@Composable
private fun StoreDeliveryInfo(
    deliveryMinTime:Int,
    deliveryMaxTime:Int,
    deliveryMinTip:Int,
    deliveryMaxTip:Int,
    modifier: Modifier = Modifier,
){
    val deliveryTime = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color(0xFF818181))) {
            append("배달 ")
        }
        append("${deliveryMinTime}~${deliveryMaxTime}분")
    }

    val deliveryTip = if (deliveryMinTip == 0) {
        buildAnnotatedString {
            append("배달팁 ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("0원")
            }
            append("~${deliveryMaxTip}원")
        }
    } else {
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color(0xFF818181))) {
                append("배달팁 ")
            }
            append("${deliveryMinTip}원~${deliveryMaxTip}원")
        }
    }

    Column(
        modifier
    ) {
        Text(
            text = deliveryTime,
            style = MaterialTheme.typography.labelMedium,
        )
        if (deliveryMinTip == 0) {
            Row {
                HighlightedText(
                    text = deliveryTip,
                    highlightedText = "배달팁 0원",
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        } else {
            Text(
                text = deliveryTip,
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun StoreTags(
    tags: List<StoreTagData>,
    modifier: Modifier = Modifier,
){
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = modifier,
    ) {
        tags.forEach { tag ->
            val containerColor = tag.type.containerColor
            val contentColor = tag.type.contentColor

            when (tag.type) {
                StoreTagType.ECONOMY_DELIVERY -> {
                    EconomyDeliveryTag()
                }

                StoreTagType.SINGLE_DELIVERY -> {
                    SingleDeliveryTag()
                }

                else -> {
                    StoreTag(
                        text = tag.text,
                        contentColor = contentColor,
                        containerColor = containerColor,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun StoreResourceItemPreview() {
    HoTheme {
        StoreResourceItem(
            StoreResource(
                name = "피자나라치킨공주 전주금암점",
                thumbnailRes = R.drawable.img_store_thumbnail_pizzaandchicken,
                rating = 4.8f,
                deliveryMinTip = 0,
                deliveryMaxTip = 3400,
                deliveryMinTime = 16,
                deliveryMaxTime = 31,
                enabledCoupon = true,
                couponText = "1,000원 할인",
                tags = listOf(
                    StoreTagData(StoreTagType.ECONOMY_DELIVERY),
                    StoreTagData(StoreTagType.SINGLE_DELIVERY),
                ),
            ),
            modifier = Modifier
                .background(Color.White)
                .padding(20.dp)
        )
    }
}

data class StoreResource(
    val name: String,
    val rating: Float,
    val deliveryMinTime: Int,
    val deliveryMaxTime: Int,
    val deliveryMinTip: Int,
    val deliveryMaxTip: Int,
    val enabledCoupon: Boolean = false,
    val couponText: String,
    val tags: List<StoreTagData>,
    val thumbnailRes: Int,
)

enum class StoreTagType(
    val containerColor: Color,
    val contentColor: Color,
) {
    ECONOMY_DELIVERY(
        contentColor = Color.Unspecified,
        containerColor = Color.Transparent,
    ),
    SINGLE_DELIVERY(
        contentColor = Color.Unspecified,
        containerColor = Color.Transparent,
    ),
    NEW(
        contentColor = Color(0xFFC15996),
        containerColor = Color(0xFFFCEFF8),
    ),
    NORMAL(
        contentColor = Color(0xFF494949),
        containerColor = Color(0xFFF5F5F5),
    ),
}

data class StoreTagData(
    val type: StoreTagType,
    val text: String = "",
)
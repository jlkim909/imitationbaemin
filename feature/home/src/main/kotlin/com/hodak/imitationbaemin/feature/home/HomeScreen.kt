package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme
import com.hodak.imitationbaemin.core.model.data.StoreResource
import com.hodak.imitationbaemin.core.model.data.StoreTagData
import com.hodak.imitationbaemin.core.model.data.StoreTagType

@Composable
internal fun HomeScreen(
    userData: TestHomeData,
    modifier: Modifier = Modifier,
) {
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
    val lastOrderItems = listOf(
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
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        HomeTopAppBar(address = userData.userAddress)
        // todo : LazyColumn을 사용해야 하나? 가로 모드를 만들기 위해 Grid를 사용해야 하나?
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(300.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 12.dp,
        ) {
            searchFood(
                text = "팟타이 나와라 뚝딱!!",
                onClick = {}
            )
            gradientBanner(
                text = "Z폴더블6 사전예약 D-1",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            retail(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            baeminDelivery(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            bannerPager(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            promotions(
                modifier = Modifier
            )
            fastLocalDelivery(
                items
            )
            lastOrder(
                lastOrderItems
            )
            termsAndConditions()
        }
    }
}

@Preview(name = "Home Screen", device = "spec:shape=Normal,width=380,height=1800,unit=dp,dpi=480")
@Composable
private fun HomeScreenPreview() {
    val testUserData = TestHomeData(
        userAddress = "전북 전주시 덕진구 모래내8길 34"
    )
    HoTheme {
        HomeScreen(
            testUserData
        )
    }
}

data class TestHomeData(val userAddress: String)
data class FoodImageButtonData(
    val imageRes: Int,
    val label: String,
    val containerColor: Color?,
)
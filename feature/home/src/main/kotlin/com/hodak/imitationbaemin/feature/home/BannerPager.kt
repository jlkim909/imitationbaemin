package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.hodak.imitationbaemin.core.designsystem.icon.HoIcons
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
internal fun LazyStaggeredGridScope.bannerPager(
    modifier: Modifier = Modifier,
) {
    item(span = StaggeredGridItemSpan.FullLine, contentType = "bannerPager") {
        val pagerState = rememberPagerState(initialPage = 0)
        val imageSlider = listOf(
            painterResource(id = R.drawable.img_slider_banner1),
            painterResource(id = R.drawable.img_slider_banner2),
            painterResource(id = R.drawable.img_slider_banner3),
            painterResource(id = R.drawable.img_slider_banner4),
        )

        LaunchedEffect(Unit) {
            while (true) {
                yield()
                delay(2600)
                pagerState.animateScrollToPage(
                    page = (pagerState.currentPage + 1) % (pagerState.pageCount)
                )
            }
        }

        Box(
            modifier = modifier,
        ){
            HorizontalPager(
                count = imageSlider.size,
                state = pagerState,
            ) { page ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .graphicsLayer {
                            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                            lerp(
                                start = 0.85f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }

                            alpha = lerp(
                                start = 0.5f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            )
                        }
                ) {
                    Image(
                        painter = imageSlider[page],
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            BannerShowButton(
                currentPage = pagerState.currentPage + 1,
                pageCount = pagerState.pageCount,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
                    .height(24.dp)
            )
        }
    }
}

@Composable
private fun BannerShowButton(
    currentPage:Int,
    pageCount:Int,
    modifier: Modifier = Modifier
){
    TextButton(
        onClick = { },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Black.copy(
                alpha = 0.5f
            ),
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(0.dp),
        border = BorderStroke(1.dp, Color.White),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 8.dp, end = 4.dp)
        ) {
            Text(
                text = "$currentPage / $pageCount",
                style = MaterialTheme.typography.labelSmall,
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = "모두 보기",
                style = MaterialTheme.typography.labelSmall,
            )
            Spacer(Modifier.width(4.dp))
            Icon(
                imageVector = HoIcons.ArrowBackIosNew,
                contentDescription = null,
                modifier = Modifier
                    .size(10.dp)
                    .rotate(180f)
            )
        }
    }
}

@Preview
@Composable
private fun BannerPagerPreview() {
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            bannerPager()
        }
    }
}
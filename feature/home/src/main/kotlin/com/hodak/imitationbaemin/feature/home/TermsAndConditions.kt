package com.hodak.imitationbaemin.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridScope
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@OptIn(ExperimentalLayoutApi::class)
internal fun LazyStaggeredGridScope.termsAndConditions(
    modifier: Modifier = Modifier
) {
    val terms =
        listOf(
            "사업자정보확인", "이용약관", "전자금융거래이용약관",
            "개인정보처리방침", "리뷰운영정책", "데이터제공정책", "소비자분쟁해결기준"
        )
    item(span = StaggeredGridItemSpan.FullLine, contentType = "termsAndConditions") {
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp)
        ) {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement
                    .spacedBy(12.dp)
            ) {
                terms.forEachIndexed { idx, term ->
                    Text(
                        text = term,
                        style = MaterialTheme.typography.labelMedium,
                        color = Color.Black.copy(
                            alpha = .5f
                        )
                    )

                    if (idx < terms.size - 1) {
                        Text(
                            text = "|",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.Black.copy(
                                alpha = .2f
                            ),
                        )
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Text(
                text = "(주)우아한형제들",
                style = MaterialTheme.typography.labelMedium.copy(
                    fontWeight = FontWeight.Bold
                ),
            )
            Spacer(Modifier.height(12.dp))
            Text(
                text = "(주)우아한형제들은 통신판매중개자로 거래 당사자가 아니므로," +
                        " 판매자가 등록한 상품정보 및 거래 등에 대해 책임을 지지 않습니다." +
                        " 단, (주)우아한형제들이 판매자로 등록 판매한 상품은 판매자로서 책임을 부담합니다",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Black.copy(
                    alpha = .5f
                )
            )
        }
    }
}

@Preview
@Composable
private fun TermsAndConditionsPreview() {
    HoTheme {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(300.dp)) {
            termsAndConditions()
        }
    }
}
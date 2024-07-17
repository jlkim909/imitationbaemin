package com.hodak.imitationbaemin.core.designsystem.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.R
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@Composable
fun EconomyDeliveryTag() {
    StoreDeliveryTag(
        text = "알뜰배달",
        color = Color(0xFF42B3AD),
        painter = painterResource(id = R.drawable.img_tag_economy_delivery)
    )
}

@Composable
fun SingleDeliveryTag() {
    StoreDeliveryTag(
        text = "한집배달",
        color = Color(0xFF2D79D9),
        painter = painterResource(id = R.drawable.img_tag_single_delivery)
    )
}

@Composable
fun StoreTag(
    text: String,
    containerColor: Color,
    contentColor: Color,
) {
    Box(
        modifier = Modifier
            .padding(top = 4.dp)
            .clip(
                RoundedCornerShape(4.dp)
            )
            .background(
                containerColor
            )
            .padding(horizontal = 4.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = contentColor,
        )
    }
}

@Composable
private fun StoreDeliveryTag(
    text: String,
    color: Color,
    painter: Painter,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium,
            color = color
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.height(
                height = 12.dp
            )
        )
    }
}

@Preview
@Composable
private fun EconomyDeliveryTagPreview() {
    HoTheme {
        EconomyDeliveryTag()
    }
}

@Preview
@Composable
private fun SingleDeliveryTagPreview() {
    HoTheme {
        SingleDeliveryTag()
    }
}

@Preview
@Composable
private fun DefaultTagPreview() {
    HoTheme {
        StoreTag(
            text = "포장가능",
            contentColor = Color(0xFF494949),
            containerColor = MaterialTheme.colorScheme.surface
        )
    }
}
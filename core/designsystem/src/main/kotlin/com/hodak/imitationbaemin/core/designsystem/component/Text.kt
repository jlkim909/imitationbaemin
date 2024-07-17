package com.hodak.imitationbaemin.core.designsystem.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hodak.imitationbaemin.core.designsystem.theme.HoTheme

@Composable
fun HighlightedText(
    text: String,
    highlightedText:String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
) {
    val emptyHighlight = rememberTextMeasurer().measure(
        text = " ",
        style = style
    )
    val textLayoutResult = rememberTextMeasurer().measure(
        text = text,
        style = style
    )
    val color = MaterialTheme.colorScheme.primary.copy(
        alpha = 0.3f
    )

    val startIdx = text.indexOf(highlightedText)
    val endIdx = startIdx + highlightedText.length


    val highlightedBounds = textLayoutResult.getPathForRange(startIdx, endIdx).getBounds()

    Box(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
        ) {
            drawRoundRect(
                color = color,
                size = Size(
                    highlightedBounds.width + emptyHighlight.size.width,
                    highlightedBounds.height / 2f,
                ),
                topLeft = Offset(x = highlightedBounds.left, highlightedBounds.height / 2.5f),
                cornerRadius = CornerRadius(12f)
            )
            drawRoundRect(
                color = color,
                size = Size(
                    emptyHighlight.size.width.dp.value,
                    textLayoutResult.size.height.dp.value / 2f
                ),
                topLeft = Offset(
                    x = highlightedBounds.right,
                    textLayoutResult.size.height.dp.value / 2.5f
                ),
                cornerRadius = CornerRadius(12f)
            )
        }
        Text(
            text = text,
            style = style,
        )
    }
}

@Composable
fun HighlightedText(
    text: AnnotatedString,
    highlightedText:String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
) {
    val emptyHighlight = rememberTextMeasurer().measure(
        text = " ",
        style = style
    )
    val textLayoutResult = rememberTextMeasurer().measure(
        text = text,
        style = style
    )
    val color = MaterialTheme.colorScheme.primary.copy(
        alpha = 0.3f
    )

    val startIdx = text.indexOf(highlightedText)
    val endIdx = startIdx + highlightedText.length


    val highlightedBounds = textLayoutResult.getPathForRange(startIdx, endIdx).getBounds()

    Box(
        modifier = modifier
    ) {
        Canvas(
            modifier = Modifier
        ) {
            drawRoundRect(
                color = color,
                size = Size(
                    highlightedBounds.width + emptyHighlight.size.width,
                    highlightedBounds.height / 2f,
                ),
                topLeft = Offset(x = highlightedBounds.left, highlightedBounds.height / 2.5f),
                cornerRadius = CornerRadius(12f)
            )
            drawRoundRect(
                color = color,
                size = Size(
                    emptyHighlight.size.width.dp.value,
                    textLayoutResult.size.height.dp.value / 2f
                ),
                topLeft = Offset(
                    x = highlightedBounds.right,
                    textLayoutResult.size.height.dp.value / 2.5f
                ),
                cornerRadius = CornerRadius(12f)
            )
        }
        Text(
            text = text,
            style = style,
        )
    }
}

@Preview
@Composable
private fun HighlightedTextPreview(){
    val text = "알뜰·한집 배달팁 0원"
    HoTheme {
        Box(
            Modifier.background(Color.White)
                .fillMaxWidth()
        ) {
            HighlightedText(
                text = text,
                highlightedText = "배달팁 0원",
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}
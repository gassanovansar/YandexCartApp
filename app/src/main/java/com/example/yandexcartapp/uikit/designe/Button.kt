package com.example.yandexcartapp.uikit.designe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yandexcartapp.uikit.theme.AppTheme

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leftContent: @Composable () -> Unit = {},
    rightContent: @Composable () -> Unit = {},
    onClick: () -> Unit
) {
    Button(
        enabled = enabled,
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = AppTheme.colors.yellow,
            contentColor = Color.White,
            disabledBackgroundColor = AppTheme.colors.yellow
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                leftContent()
            }
        }
        Text(
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            text = text,
            style = AppTheme.typography.bold.copy(
                fontSize = 18.sp,
                color = if (enabled) AppTheme.colors.black else AppTheme.colors.black,
                textAlign = TextAlign.Center,
            )
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                rightContent()
            }

        }
    }
}

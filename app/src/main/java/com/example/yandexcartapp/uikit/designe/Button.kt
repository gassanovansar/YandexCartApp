package com.example.yandexcartapp.uikit.designe

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 14.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
    ) {
        leftContent()
        Text(
            maxLines = 1,
            modifier = Modifier,
            text = text,
            style = AppTheme.typography.semiBold.copy(
                fontSize = 16.sp,
                color = if (enabled) AppTheme.colors.yellow else AppTheme.colors.yellow,
                textAlign = TextAlign.Center,
            )
        )
        rightContent()
    }
}

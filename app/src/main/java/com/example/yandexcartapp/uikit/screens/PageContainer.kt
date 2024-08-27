package com.example.yandexcartapp.uikit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import com.example.yandexcartapp.uikit.theme.AppTheme


@Composable
fun PageContainer(
    modifier: Modifier = Modifier,
    background: Color = AppTheme.colors.gray,
    brush: Brush? = null,
    fill: Boolean = true,
    isLoading: State<Boolean> = mutableStateOf(false),
    header: @Composable (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
    footer: @Composable (BoxScope.() -> Unit)? = null,
) {
    var modifier = if (brush != null) {
        modifier.background(brush)
    } else {
        modifier.background(background)
    }
    modifier = modifier.fillMaxHeight()

    val localFocusManager = LocalFocusManager.current

    DisposableEffect(key1 = localFocusManager) {
        onDispose {
            localFocusManager.clearFocus(true)
        }
    }
    Box {


        Column(
            modifier = modifier
                .fillMaxWidth()
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        localFocusManager.clearFocus()
                    })
                }
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                header?.invoke()
            }

            Box(
                modifier = Modifier.weight(1f)
            ) {
                content()
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                footer?.invoke(this)
            }


        }
        if (isLoading.value) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(AppTheme.colors.black.copy(alpha = 0.5F))
            )
        }
    }


}


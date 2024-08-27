package com.example.yandexcartapp.uikit.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yandexcartapp.R
import com.example.yandexcartapp.core.ext.clickableDebounce
import com.example.yandexcartapp.domain.model.CartItem
import com.example.yandexcartapp.uikit.designe.AppCard
import com.example.yandexcartapp.uikit.theme.AppTheme


@Composable
fun CartItem(item: CartItem, increaseOnClick: () -> Unit, decreaseOnClick: () -> Unit) {
    Row(
        Modifier
            .clickable { }
            .padding(horizontal = 16.dp)
    ) {
        AppCard(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.CenterVertically)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                modifier = Modifier,
                text = item.name,
                style = AppTheme.typography.medium.copy(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = AppTheme.colors.black,
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                modifier = Modifier,
                text = "${item.currency} ${item.price}",
                style = AppTheme.typography.semiBold.copy(
                    fontSize = 16.sp,
                    color = AppTheme.colors.black1,
                )
            )
        }
        AppCard(
            backgroundColor = AppTheme.colors.gray,
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Row {
                Text(
                    modifier = Modifier
                        .clickableDebounce(enabled = item.count > 1) {
                            decreaseOnClick()
                        }
                        .padding(horizontal = 12.dp)
                        .align(Alignment.CenterVertically),
                    text = "-",
                    style = AppTheme.typography.medium.copy(
                        fontSize = 24.sp,
                        color = AppTheme.colors.black,
                    )
                )
                Box(
                    modifier = Modifier
                        .padding()
                        .width(32.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = item.count.toString(),
                        style = AppTheme.typography.medium.copy(
                            fontSize = 14.sp,
                            color = AppTheme.colors.black,
                        )
                    )
                }

                Text(
                    modifier = Modifier
                        .clickableDebounce(enabled = item.count < 99) {
                            increaseOnClick()
                        }
                        .padding(horizontal = 12.dp)
                        .align(Alignment.CenterVertically),
                    text = "+",
                    style = AppTheme.typography.medium.copy(
                        fontSize = 24.sp,
                        color = AppTheme.colors.black,
                    )
                )
            }
        }

    }
}
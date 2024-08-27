package com.example.yandexcartapp.feature.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yandexcartapp.uikit.components.CartItem
import com.example.yandexcartapp.uikit.designe.AppCard
import com.example.yandexcartapp.uikit.designe.BackIcon
import com.example.yandexcartapp.uikit.designe.PrimaryButton
import com.example.yandexcartapp.uikit.designe.Toolbar
import com.example.yandexcartapp.uikit.screens.PageContainer
import com.example.yandexcartapp.uikit.theme.AppTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.yandexcartapp.R
import com.example.yandexcartapp.core.ext.clickableRound

@Composable
fun CartScreen(viewModel: CartScreenModel = viewModel()) {

    val state by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.getCartItem()
    }
    PageContainer(
        header = {
            Toolbar(
                modifier = Modifier.background(AppTheme.colors.white),
                leftIcon = {
                    BackIcon()
                }, rightIcon = {
                    Image(
                        modifier = Modifier.clickableRound(2.dp) {
                            viewModel.deleteCart()
                        },
                        painter = painterResource(id = R.drawable.ic_delete_cart),
                        contentDescription = ""
                    )
                }
            )
        },
        content = {

            AppCard(
                elevation = 0.dp,
                shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp),
                backgroundColor = AppTheme.colors.white
            ) {
                LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)) {
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp)
                                .padding(horizontal = 16.dp),
                            text = "Избранное",
                            style = AppTheme.typography.bold.copy(
                                fontSize = 24.sp,
                                color = AppTheme.colors.black,
                            )
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            text = "${state.carts.size} блюда",
                            style = AppTheme.typography.medium.copy(
                                fontSize = 16.sp,
                                color = AppTheme.colors.gray1,
                            )
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                    }
                    itemsIndexed(state.carts) { index, item ->
                        CartItem(item, {
                            viewModel.increase(item)
                        }, {
                            viewModel.decrease(item)
                        })
                        if (index < state.carts.size - 1)
                            Divider(
                                color = AppTheme.colors.gray2,
                                thickness = 1.dp,
                                modifier = Modifier
                                    .padding(start = 96.dp, end = 16.dp)
                                    .padding(vertical = 4.dp)
                            )
                    }
                }
            }
        },
        footer = {
            AppCard(
                elevation = 2.dp,
                shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp),
                backgroundColor = AppTheme.colors.white
            ) {
                PrimaryButton(
                    text = "Далее",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    rightContent = {
                        Text(
                            modifier = Modifier,
                            text = "${state.allPrice} ₽",
                            style = AppTheme.typography.bold.copy(
                                fontSize = 20.sp,
                                color = AppTheme.colors.black,
                            )
                        )
                    }) {

                }
            }
        }
    )

}


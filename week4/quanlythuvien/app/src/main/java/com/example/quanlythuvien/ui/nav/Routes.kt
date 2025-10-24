package com.example.quanlythuvien.ui.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
sealed class Destination(val label: String) {
    @Serializable
    data object Home: Destination("Home")
    @Serializable
    data object Shopping: Destination("Cart")
    @Serializable
    data object Favorites: Destination("Favorites")
}
sealed class BottomNavigation(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int,
    val route: Destination
) {
    data object Home : BottomNavigation("Quản lý",
        Icons.Filled.Home,
        Icons.Outlined.Home,
        0,
        Destination.Home
    )
    data object Shopping : BottomNavigation("DS sách",
        Icons.Filled.ShoppingCart,
        Icons.Outlined.ShoppingCart,
        0,
        Destination.Shopping
    )
    data object Favorites : BottomNavigation("Sinh viên",
        Icons.Filled.Favorite,
        Icons.Outlined.FavoriteBorder,
        0,
        Destination.Favorites
    )
}
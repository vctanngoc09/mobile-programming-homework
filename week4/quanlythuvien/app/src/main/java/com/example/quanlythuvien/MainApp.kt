package com.example.quanlythuvien

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.quanlythuvien.ui.components.MyBottomBar
import com.example.quanlythuvien.ui.components.MyTopBar
import com.example.quanlythuvien.ui.nav.BottomNavigation
import com.example.quanlythuvien.ui.nav.MyAppNavgation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    val navController: NavHostController = rememberNavController()
    val navBackStackEntry by
    navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(
        topBar = {
            MyTopBar()
        },
        bottomBar = {
            MyBottomBar(navController, currentDestination)
        }
    ) { innerPadding ->
        MyAppNavgation(navController = navController,
            modifier = Modifier.padding(innerPadding))
    }
}
package com.example.uthsmart.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uthsmart.ui.screen.Welcome1
import com.example.uthsmart.ui.screen.Welcome
import com.example.uthsmart.ui.screen.Welcome2
import com.example.uthsmart.ui.screen.Welcome3

@Composable
fun MyAppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.welcome, builder = {
        composable(Routes.welcome){
            Welcome(
                onNext = {
                    navController.navigate(Routes.welcome1) {
                        popUpTo(Routes.welcome) { inclusive = true } // Xóa splash khỏi back stack
                    }
                }
            )
        }

        composable(Routes.welcome1){
            Welcome1(onNext = { navController.navigate(Routes.welcome2) })
        }

        composable(Routes.welcome2){
            Welcome2(onNext = { navController.navigate(Routes.welcome3)},
                onBack = { navController.popBackStack() })
        }

        composable(Routes.welcome3) {
            Welcome3(
                onNext = {
                navController.navigate(Routes.welcome1) {
                    popUpTo(Routes.welcome1) {
                        inclusive = true // xóa luôn welcome1 cũ nếu có, rồi tạo lại mới
                    }
                }
            },
                onBack = {navController.popBackStack()}
            )
        }
    })
}
package com.example.ungdunghienuicoban.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ungdunghienuicoban.ui.screen.Columns
import com.example.ungdunghienuicoban.ui.screen.Components
import com.example.ungdunghienuicoban.ui.screen.Image
import com.example.ungdunghienuicoban.ui.screen.LazyColumn
import com.example.ungdunghienuicoban.ui.screen.Passwordfields
import com.example.ungdunghienuicoban.ui.screen.Rows
import com.example.ungdunghienuicoban.ui.screen.Textfield
import com.example.ungdunghienuicoban.ui.screen.Textdetail
import com.example.ungdunghienuicoban.ui.screen.Welcome
import okhttp3.Route

@Composable
fun MyAppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.welcome, builder = {
        composable(Routes.welcome,) {
            Welcome(onNext = { navController.navigate(Routes.lazycolumn) })
        }
        composable(Routes.lazycolumn,){ 
            LazyColumn(navController)
        }
        composable(Routes.textDetail,) {
            Textdetail(onBack = {navController.popBackStack()})
        }
        composable(Routes.image,) {
            Image(onBack = {navController.popBackStack()})
        }

        composable(Routes.textfield) {
            Textfield( onBack = {navController.popBackStack()} )
        }

        composable(Routes.column) {
            Columns (onBack = {navController.popBackStack()})
        }

        composable(Routes.row) {
            Rows(onBack ={navController.popBackStack()})
        }

        composable(Routes.passwordfield) {
            Passwordfields(onBack = {navController.popBackStack()})
        }
    })
}
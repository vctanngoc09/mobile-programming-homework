package com.example.quanlythuvien.ui.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quanlythuvien.ui.screen.Book
import com.example.quanlythuvien.ui.screen.Home
import com.example.quanlythuvien.ui.screen.Student
import com.example.quanlythuvien.viewmodel.LibraryViewModel

@Composable
fun MyAppNavgation(navController: NavHostController, modifier: Modifier = Modifier){
    val libraryViewModel: LibraryViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = Destination.Home,
        modifier = modifier
    ) {
        composable<Destination.Home> { Home(viewModel = libraryViewModel) }
        composable<Destination.Shopping> { Book(viewModel = libraryViewModel) }
        composable<Destination.Favorites> { Student(viewModel = libraryViewModel) }
    }
}
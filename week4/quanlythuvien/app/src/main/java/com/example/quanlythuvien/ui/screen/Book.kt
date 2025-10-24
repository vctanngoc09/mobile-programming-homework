package com.example.quanlythuvien.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quanlythuvien.model.Book
import com.example.quanlythuvien.ui.theme.Bluee
import com.example.quanlythuvien.ui.theme.White
import com.example.quanlythuvien.viewmodel.LibraryViewModel

@Composable
fun Book(
    viewModel: LibraryViewModel
) {
    var bookName by remember { mutableStateOf("") }
    val books = viewModel.books // ✅ lấy danh sách từ ViewModel

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Danh sách sách",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = bookName,
                onValueChange = { bookName = it },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),
                singleLine = true,
                placeholder = { Text("Tên sách", fontSize = 14.sp) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (bookName.isNotBlank()) {
                        viewModel.addBook(bookName) // ✅ thêm vào ViewModel
                        bookName = ""
                    }
                },
                modifier = Modifier.height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Bluee,
                    contentColor = White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Thêm", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(books) { book ->
                BookItem(
                    book = book,
                    onDelete = { viewModel.removeBook(book) } // ✅ xóa qua ViewModel
                )
            }
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color(0xFFE6E6E6), RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(book.getTitle(), modifier = Modifier.weight(1f))
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Xóa")
            }
        }
    }
}

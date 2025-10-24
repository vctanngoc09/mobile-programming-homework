package com.example.quanlythuvien.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quanlythuvien.ui.theme.Bluee
import com.example.quanlythuvien.ui.theme.GrayLight
import com.example.quanlythuvien.ui.theme.GrayMedium
import com.example.quanlythuvien.ui.theme.White
import com.example.quanlythuvien.model.Student
import com.example.quanlythuvien.model.Book
import com.example.quanlythuvien.model.LibraryManager
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quanlythuvien.viewmodel.LibraryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    viewModel: LibraryViewModel
) {

    // danh sách sách
    var selectedBooks by remember { mutableStateOf(setOf<Book>()) }
    var selectedStudent by remember { mutableStateOf<Student?>(null) }
    var expanded by remember { mutableStateOf(false) }
    val students = viewModel.students
    val books = viewModel.books
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // ====== Sinh viên ======
        Text(
            text = "Sinh viên",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        var showDialog by remember { mutableStateOf(false) }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    if (students.isNotEmpty()) showDialog = true
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                OutlinedTextField(
                    value = selectedStudent?.getDisplayName() ?: "Chọn học sinh",
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .height(56.dp),
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(fontSize = 14.sp)
                )

                // LƯU Ý: Xóa dropdown menu ra khỏi đây
                ExposedDropdownMenu(
                    expanded = false,
                    onDismissRequest = {}
                ) {}
            }

            Button(
                onClick = {
                    if (students.isNotEmpty()) showDialog = true
                },
                modifier = Modifier.height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Bluee,
                    contentColor = White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Thay đổi", fontSize = 14.sp)
            }
        }

        if (showDialog) {
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {},
                text = {
                    LazyColumn(
                        modifier = Modifier
                            .heightIn(max = 300.dp)
                            .fillMaxWidth()
                    ) {
                        items(students) { student ->
                            Button(
                                onClick = {
                                    selectedStudent = student
                                    showDialog = false
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black
                                )
                            ) {
                                Text(student.getDisplayName())
                            }
                        }
                    }
                },
                title = {
                    Text("Chọn sinh viên")
                }
            )
        }



        Spacer(modifier = Modifier.height(16.dp))

        // ====== Danh sách sách ======
        Text(
            text = "Danh sách sách",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(GrayMedium)
                .padding(8.dp)
                .height(200.dp)
        ) {
            LazyColumn {
                items(books) { book ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(horizontal = 8.dp, vertical = 6.dp)
                    ) {
                        Checkbox(
                            checked = book in selectedBooks,
                            onCheckedChange = { checked ->
                                selectedBooks =
                                    if (checked) selectedBooks + book
                                    else selectedBooks - book
                            },
                            colors = CheckboxDefaults.colors(checkedColor = Color(0xFF9C27B0))
                        )
                        Text(
                            text = book.getTitle(),
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ====== Nút Thêm ======
        Button(
            onClick = {
                val student = selectedStudent
                if (student != null && selectedBooks.isNotEmpty()) {
                    selectedBooks.forEach { book ->
                        viewModel.borrowBook(student, book)
                    }
                    selectedBooks = viewModel.getBooksBorrowed(student).toSet()
                } else {
                    println("Chưa chọn sinh viên hoặc chưa có sách")
                }
            },
            modifier = Modifier.height(48.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Bluee,
                contentColor = White
            ),
            contentPadding = PaddingValues(
                horizontal = 24.dp,
                vertical = 16.dp
            ),
        ) {
            Text("Thêm")
        }
    }
}







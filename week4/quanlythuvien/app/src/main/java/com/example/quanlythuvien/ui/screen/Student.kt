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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quanlythuvien.model.Student
import com.example.quanlythuvien.viewmodel.LibraryViewModel
import com.example.quanlythuvien.ui.theme.Bluee
import com.example.quanlythuvien.ui.theme.White

@Composable
fun Student(
    viewModel: LibraryViewModel
) {
    var studentName by remember { mutableStateOf("") }
    val students = viewModel.students  // ✅ lấy dữ liệu từ ViewModel

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            "Danh sách sinh viên",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = studentName,
                onValueChange = { studentName = it },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .padding(end = 8.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(fontSize = 14.sp),
                placeholder = { Text("Tên sinh viên", fontSize = 14.sp) }
            )

            Button(
                onClick = {
                    if (studentName.isNotBlank()) {
                        viewModel.addStudent(studentName)
                        studentName = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Bluee,
                    contentColor = White
                ),
                modifier = Modifier.height(56.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Thêm", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(students) { student ->
                StudentItem(
                    student = student,
                    onDelete = { viewModel.removeStudent(student) } // ✅ gọi ViewModel
                )
            }
        }
    }
}

@Composable
fun StudentItem(
    student: Student,
    onDelete: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color(0xFFE6E6E6), RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(student.getDisplayName(), modifier = Modifier.weight(1f))
            IconButton(onClick = onDelete) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Xóa"
                )
            }
        }
    }
}

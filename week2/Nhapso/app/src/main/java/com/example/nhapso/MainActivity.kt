package com.example.nhapso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nhapso.ui.theme.NhapsoTheme
import com.example.nhapso.ui.theme.Red

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NhapsoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.fillMaxSize()
                        .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        NumberScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun NumberScreen() {
    // Biến trạng thái
    var inputValue by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var numbers by remember { mutableStateOf(listOf<Int>()) }
    var welcomeMessage =
        stringResource(id = R.string.ten_ung_dung)
    var tao =
        stringResource(id = R.string.nut_tao)
    var loi =
        stringResource(id = R.string.loi)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = welcomeMessage,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputValue,
                onValueChange = { inputValue = it },
                label = { Text("Nhập vào số lượng") },
                isError = isError,
                shape = RoundedCornerShape(16.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Red,
                    unfocusedBorderColor = Red,
                    cursorColor = Red,
                    focusedTextColor = Red,
                    unfocusedTextColor = Red,
                    focusedLabelColor = Red,
                    unfocusedLabelColor = Red
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    val number = inputValue.toIntOrNull()
                    if (number != null && number > 0) {
                        isError = false
                        numbers = (1..number).toList()
                    } else {
                        isError = true
                        numbers = emptyList()
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                modifier = Modifier.height(52.dp),
                contentPadding = PaddingValues(horizontal = 20.dp)

            ) {
                Text(tao)
            }
        }

        if (isError) {
            Text(
                text = loi,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Hiển thị danh sách các số
        numbers.forEach { number ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .background(Color.Red, shape = RoundedCornerShape(20.dp))
                    .padding(vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
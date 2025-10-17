package com.example.ungdunghienuicoban.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ungdunghienuicoban.R
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.ungdunghienuicoban.ui.theme.Black
import com.example.ungdunghienuicoban.ui.theme.Red


@Composable
fun Textfield(onBack: () -> Unit,){
    var text by remember { mutableStateOf("") }
    val isError = text.length > 20 // ví dụ validate
    UngdunghienuicobanTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                // tạo scroll state để nhớ vị trí cuộn
                val scrollState = rememberScrollState()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(scrollState), // 👈 Thêm dòng này
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center // căn giữa cho Text
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically // canh giữa theo ngang
                        ) {
                            Image(
                                painter = painterResource(R.drawable.back),
                                contentDescription = "Back",
                                modifier = Modifier
                                    .size(8.dp, 15.dp)
                                    .clickable(onClick = onBack),
                                contentScale = ContentScale.Crop
                            )
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "TextField",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                color = Blue
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    var firstName by remember { mutableStateOf("") }
                    TextField(
                        value = text,
                        onValueChange = {text = it},
                        label = { Text(text = "text") },
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    BasicTextField(
                        value = text, onValueChange = { text = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Blue, RoundedCornerShape(12.dp))
                            .padding(12.dp)
                    )

                    Spacer(modifier = Modifier.height(30.dp))


                    OutlinedTextField(
                        value = text,
                        onValueChange = {text = it},
                        label = { Text("text") },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    // TextField (Material3)
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        placeholder = { Text("Thông tin nhập") },               // placeholder (hint)
                        singleLine = true,                                       // 1 dòng
                        shape = RoundedCornerShape(20.dp),                       // bo góc
                        leadingIcon = { Icon(Icons.Default.Edit, null) },        // icon trái (tùy chọn)
                        trailingIcon = {
                            if (text.isNotEmpty()) {
                                IconButton(onClick = { text = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Xóa")
                                }
                            }
                        },                                                       // icon phải (tùy chọn)
                        isError = isError,                                       // trạng thái lỗi
                        supportingText = {
                            if (isError) Text("Tối đa 20 ký tự", color = MaterialTheme.colorScheme.error)
                        },                                                       // dòng chú thích dưới (helper/error)
                        modifier = Modifier
                            .fillMaxWidth()
                    )

                    Spacer(Modifier.height(16.dp))

                    // Dòng bên dưới tự động cập nhật theo TextField (giống caption đỏ trong ảnh)
                    Text(
                        text = if (text.isEmpty()) "Tự động cập nhật dữ liệu theo textfield" else text,
                        color = Red,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
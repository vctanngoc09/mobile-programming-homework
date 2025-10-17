package com.example.ungdunghienuicoban.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ungdunghienuicoban.R
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.lint.kotlin.metadata.Visibility


@Composable /// implementation("androidx.compose.material:material-icons-extended")
fun Passwordfields(onBack: () -> Unit) { // ← bỏ dấu phẩy thừa ở đây
    UngdunghienuicobanTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                val scrollState = rememberScrollState()
                val fm = LocalFocusManager.current

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp)
                        .verticalScroll(scrollState),
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
                    Spacer(Modifier.height(24.dp))

                    // 1) Cơ bản
                    SectionTitle("1) Cơ bản")
                    var pwd1 by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = pwd1,
                        onValueChange = { pwd1 = it },
                        label = { Text("Mật khẩu") },
                        placeholder = { Text("Nhập mật khẩu") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 2) Ẩn/Hiện (toggle)
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("2) Ẩn/Hiện mật khẩu (toggle)")
                    var pwd2 by remember { mutableStateOf("") }
                    var visible2 by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = pwd2,
                        onValueChange = { pwd2 = it },
                        label = { Text("Mật khẩu") },
                        singleLine = true,
                        visualTransformation = if (visible2) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { visible2 = !visible2 }) {
                                Icon(
                                    imageVector = if (visible2) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 3) Leading/Trailing icon + nút xóa nhanh
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("3) Icon trái/phải + nút xóa")
                    var pwd3 by remember { mutableStateOf("") }
                    var visible3 by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = pwd3,
                        onValueChange = { pwd3 = it },
                        label = { Text("Mật khẩu") },
                        singleLine = true,
                        leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = null) },
                        trailingIcon = {
                            Row {
                                if (pwd3.isNotEmpty()) {
                                    IconButton(onClick = { pwd3 = "" }) {
                                        Icon(Icons.Filled.Clear, contentDescription = "Xóa")
                                    }
                                }
                                IconButton(onClick = { visible3 = !visible3 }) {
                                    Icon(
                                        imageVector = if (visible3) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                        contentDescription = null
                                    )
                                }
                            }
                        },
                        visualTransformation = if (visible3) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 4) Validation + trạng thái lỗi + supporting text
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("4) Validation + lỗi + supporting text")
                    var pwd4 by remember { mutableStateOf("") }
                    val isError4 = pwd4.length < 6
                    OutlinedTextField(
                        value = pwd4,
                        onValueChange = { pwd4 = it },
                        label = { Text("Mật khẩu (≥ 6 ký tự)") },
                        singleLine = true,
                        isError = isError4,
                        supportingText = {
                            if (isError4) Text("Tối thiểu 6 ký tự", color = MaterialTheme.colorScheme.error)
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 5) Keyboard/IME (Password + Done)
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("5) Bàn phím Password + IME Done")
                    var pwd5 by remember { mutableStateOf("") }
                    var visible5 by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = pwd5,
                        onValueChange = { pwd5 = it },
                        label = { Text("Mật khẩu") },
                        singleLine = true,
                        visualTransformation = if (visible5) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { visible5 = !visible5 }) {
                                Icon(
                                    imageVector = if (visible5) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = { fm.clearFocus() }),
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 6) Strength meter (độ mạnh)
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("6) Thanh độ mạnh mật khẩu")
                    var pwd6 by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = pwd6,
                        onValueChange = { pwd6 = it },
                        label = { Text("Mật khẩu") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(8.dp))
                    PasswordStrengthBar(password = pwd6)

                    // 7) Colors & Shape
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("7) Tùy biến màu & bo góc")
                    var pwd7 by remember { mutableStateOf("") }
                    var visible7 by remember { mutableStateOf(false) }
                    OutlinedTextField(
                        value = pwd7,
                        onValueChange = { pwd7 = it },
                        label = { Text("Mật khẩu") },
                        singleLine = true,
                        shape = RoundedCornerShape(14.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary,
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                            focusedLabelColor = MaterialTheme.colorScheme.primary,
                            cursorColor = MaterialTheme.colorScheme.primary
                        ),
                        visualTransformation = if (visible7) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { visible7 = !visible7 }) {
                                Icon(
                                    imageVector = if (visible7) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                                    contentDescription = null
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )

                    // 8) Disabled / ReadOnly
                    Spacer(Modifier.height(16.dp))
                    SectionTitle("8) Disabled / ReadOnly")
                    OutlinedTextField(
                        value = "********",
                        onValueChange = {},
                        label = { Text("Mật khẩu (chỉ đọc)") },
                        readOnly = true,
                        enabled = false,
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(24.dp))
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    )
}

@Composable
private fun PasswordStrengthBar(password: String, modifier: Modifier = Modifier) {
    val score = remember(password) {
        listOf(
            password.length >= 6,
            password.any(Char::isUpperCase) && password.any(Char::isLowerCase),
            password.any { it.isDigit() || "!@#\$%^&*".contains(it) }
        ).count { it }
    }
    LinearProgressIndicator(
        progress = (score / 3f),
        modifier = modifier
            .fillMaxWidth()
            .height(6.dp),
    )
}

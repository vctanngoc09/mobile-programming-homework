package com.example.xemtuoi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.xemtuoi.ui.theme.Blue
import com.example.xemtuoi.ui.theme.GrayDark
import com.example.xemtuoi.ui.theme.GrayLight
import com.example.xemtuoi.ui.theme.GrayMedium
import com.example.xemtuoi.ui.theme.Green
import com.example.xemtuoi.ui.theme.Red
import com.example.xemtuoi.ui.theme.White
import com.example.xemtuoi.ui.theme.XemtuoiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XemtuoiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Xemtuoi()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XemtuoiTheme {
        Greeting("Android")
    }
}


@Composable
fun Xemtuoi(){
    var checkage by remember { mutableStateOf("") }
    var checkname by remember { mutableStateOf("") }
    var appName = stringResource(id = R.string.app_name)
    var fullName = stringResource(id = R.string.full_name)
    var age = stringResource(id = R.string.age)
    var enterButton = stringResource(id = R.string.enter_button)
    var gia = stringResource(id = R.string.gia)
    var lon = stringResource(id = R.string.lon)
    var tre = stringResource(id = R.string.tre)
    var be = stringResource(id = R.string.be)
    var notification by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = appName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(80.dp))

        // 👉 Khung nền xám bo tròn
        Column(
            modifier = Modifier
                .background(GrayMedium, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
                .fillMaxWidth(0.9f), // cho nhỏ hơn màn hình 1 chút
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // ===== Hàng họ và tên =====
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // 👉 căn giữa label & input theo chiều dọc
            ) {
                Text(
                    text = fullName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(80.dp) // giữ label cố định
                )
                OutlinedTextField(
                    value = checkname,
                    onValueChange = { checkname = it },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .background(White, shape = RoundedCornerShape(12.dp)),
                )
            }

            // ===== Hàng tuổi =====
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = age,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.width(80.dp)
                )
                OutlinedTextField(
                    value = checkage,
                    onValueChange = { checkage = it },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .weight(1f)
                        .background(White, shape = RoundedCornerShape(12.dp)),
                )
            }
        }

        if (notification.isNotEmpty()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = if (!isError) "$checkname $notification" else notification,
                color = if (isError) Red else Green
            )
        }

        // ===== Nút kiểm tra =====
        Button(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(0.5f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,
                contentColor = White
            ),
            onClick = {
                val number = checkage.toIntOrNull()
                if (number != null && checkname.isNotBlank()) {
                    when {
                        number >= 65 -> {
                            notification = gia; isError = false
                        }
                        number >= 6 -> {
                            notification = lon; isError = false
                        }
                        number >= 2 -> {
                            notification = tre; isError = false
                        }
                        number > 0 -> {
                            notification = be; isError = false
                        }
                        else -> {
                            notification = "Tuổi không hợp lệ"; isError = true
                        }
                    }
                } else {
                    notification = "Vui lòng nhập thông tin hợp lệ"
                    isError = true
                }
            }
        ) {
            Text(
                text = enterButton,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


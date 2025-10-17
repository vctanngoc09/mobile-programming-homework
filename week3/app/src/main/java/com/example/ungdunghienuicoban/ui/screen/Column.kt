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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ungdunghienuicoban.R
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.Bluesmall
import com.example.ungdunghienuicoban.ui.theme.Green
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme
import com.example.ungdunghienuicoban.ui.theme.Yellow

@Composable
fun Columns(onBack: () -> Unit,){
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
                                text = "Column layout",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                color = Blue
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(Bluesmall)

                    ){
                        Column(
                            modifier = Modifier.fillMaxWidth()
                                .padding(15.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),

                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier.fillMaxWidth()
                                    .height(100.dp),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Green)
                            ) { }

                            Button(
                                onClick = {},
                                modifier = Modifier.fillMaxWidth()
                                    .height(100.dp),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Yellow)
                            ) {  }

                            Button(
                                onClick = {},
                                modifier = Modifier.fillMaxWidth()
                                    .height(100.dp),
                                shape = RoundedCornerShape(14.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Green)
                            ) {  }
                        }
                    }
                }
            }
        }
    }
}
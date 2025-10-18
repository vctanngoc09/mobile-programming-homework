package com.example.ungdunghienuicoban.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ungdunghienuicoban.ui.nav.Routes
import com.example.ungdunghienuicoban.ui.theme.Black
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.Bluesmall
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme


@Composable
fun ColumnScroll(navController: NavController){
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
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Column",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center,
                        color = Blue
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)

                    ) {
                        Text(
                            text = "Display",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(
                                horizontal = 8.dp,
                                vertical = 16.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Bluesmall,
                                contentColor = Black
                            ),
                            onClick = {
                                navController.navigate(Routes.textDetail)
                            }
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(start = 5.dp)
                            ) {
                                Text(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    text = "Text"
                                )
                                Text(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    text = "Displays text"
                                )
                            }
                        }
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(10.dp),
                            contentPadding = PaddingValues(
                                horizontal = 8.dp,
                                vertical = 16.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Bluesmall,
                                contentColor = Black
                            ),
                            onClick = {
                                navController.navigate(Routes.image)
                            }
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(5.dp)
                            ) {
                                Text(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    text = "Image"
                                )
                                Text(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    text = "Displays an image"
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }
    }
}


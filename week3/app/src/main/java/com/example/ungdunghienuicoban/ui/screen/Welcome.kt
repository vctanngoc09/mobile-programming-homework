package com.example.ungdunghienuicoban.ui.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ungdunghienuicoban.R
import com.example.ungdunghienuicoban.ui.nav.MyAppNavigation
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.Poppins
import com.example.ungdunghienuicoban.ui.theme.White
import com.example.ungdunghienuicoban.ui.nav.Routes
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme

@Composable
fun Welcome(onNext: () -> Unit){
    UngdunghienuicobanTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Võ Cao Tấn Ngọc",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()

                    )
                    Text(
                        text = "051205000133",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Right,
                        modifier = Modifier.fillMaxWidth()

                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "Profile picture",
                        modifier = Modifier.size(150.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = "Jetpack Compose",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.W500
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Center, // căn giữa nội dung văn bản
                        modifier = Modifier.fillMaxWidth() // căn giữa toàn dòng trong Button
                    )
                    Spacer(modifier = Modifier.height(150.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(
                            horizontal = 8.dp, // tăng ngang
                            vertical = 16.dp    // tăng dọc
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Blue,
                            contentColor = White
                        ),
                        onClick = onNext
                    ) {
                        Text("i'm ready",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W700 // Bold
                        )
                    }

                }
            }
        }
    }
}

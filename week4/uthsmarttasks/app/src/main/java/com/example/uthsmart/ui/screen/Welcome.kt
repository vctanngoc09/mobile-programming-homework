package com.example.uthsmart.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uthsmart.R
import com.example.uthsmart.ui.theme.Blue
import com.example.uthsmart.ui.theme.Bluee
import com.example.uthsmart.ui.theme.PrimaryLight

@Composable
fun Welcome(onNext: () -> Unit){
    // Hiệu ứng tự động chuyển sau 5 giây
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(5000) // 5000ms = 5s
        onNext()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(200.dp))
        Image(
            painter = painterResource(R.drawable.uth),
            contentDescription = "uth",
            modifier = Modifier
                .size(102.dp, 70.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "UTH SmartTasks",
            fontSize = 30.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Center,
            color = Bluee
        )
    }
}
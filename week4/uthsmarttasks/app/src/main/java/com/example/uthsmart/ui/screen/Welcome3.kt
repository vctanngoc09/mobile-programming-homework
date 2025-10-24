package com.example.uthsmart.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uthsmart.R
import com.example.uthsmart.ui.theme.Black
import com.example.uthsmart.ui.theme.Bluee
import com.example.uthsmart.ui.theme.Bluesmall
import com.example.uthsmart.ui.theme.ShadowBlue
import com.example.uthsmart.ui.theme.White

@Composable
fun Welcome3(onNext: () -> Unit,
             onBack: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        // Top: dots + Skip
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PageDots(
                total = 3,
                current = 2,
            )
            TextButton(onClick = {},
                contentPadding = PaddingValues(
                    horizontal = 0.dp,
                    vertical = 0.dp
                ),) {
                Text(
                    text = "skip",
                    color = Bluee
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.w3),
            contentDescription = "uth",
            modifier = Modifier
                .height(260.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Reminder Notification",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = Black
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(53.dp, 53.dp)
                    .clickable(onClick = onBack),
                contentScale = ContentScale.Crop
            )
            Button(
                modifier = Modifier.height(53.dp)
                    .width(260.dp),
                shape = RoundedCornerShape(10.dp),
                contentPadding = PaddingValues(
                    horizontal = 8.dp,
                    vertical = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ShadowBlue,
                    contentColor = White
                ),
                onClick = onNext
            ) {
                Text(
                    text = "Next",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = White
                )
            }
        }
    }
}

@Composable
private fun PageDots(total: Int, current: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(total) { i ->
            val size by animateDpAsState(
                targetValue = if (i == current) 10.dp else 6.dp,
                animationSpec = spring(dampingRatio = 0.9f), label = "dotSize"
            )
            Box(
                modifier = Modifier
                    .padding(end = if (i == total - 1) 0.dp else 6.dp)
                    .size(size)
                    .clip(CircleShape)
                    .background(
                        if (i == current)
                            Bluee
                        else
                            Bluesmall
                    )
            )
        }
    }
}
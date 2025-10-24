package com.example.thuchanh1tailop

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuchanh1tailop.ui.theme.Blue
import com.example.thuchanh1tailop.ui.theme.PrimaryDark
import com.example.thuchanh1tailop.ui.theme.Thuchanh1tailopTheme
import com.example.thuchanh1tailop.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Thuchanh1tailopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        layout()
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
    Thuchanh1tailopTheme {
        Greeting("Android")
    }
}

@Composable
fun sayhi(){
    var ten by remember { mutableStateOf("Võ Cao Tấn Ngọc") }
    var chao by remember { mutableStateOf("Hello") }
    var iam by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))


        Text(
            text = "My First App",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = iam,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = chao,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(0.5f)
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryDark,
                contentColor = White
            ),
            onClick = {
                iam = "I'am"
                chao = ten
            }
        ) {
            Text(
                text = "Say Hi",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Composable
fun layout(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.hinh), // thay avatar.png trong res/drawable
            contentDescription = "Profile picture",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Jetpack Compose",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Jetpack Compose asa dsadsdasdasdasdas",
            fontSize = 22.sp
        )

    }
}
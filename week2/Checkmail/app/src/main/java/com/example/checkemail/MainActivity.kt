package com.example.checkemail

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import com.example.checkemail.ui.theme.Blue
import com.example.checkemail.ui.theme.CheckemailTheme
import com.example.checkemail.ui.theme.Green
import com.example.checkemail.ui.theme.Red
import com.example.checkemail.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CheckemailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        FormCheckMail()
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
    CheckemailTheme {
        Greeting("Android")
    }
}


fun isValidEmail(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
@Composable
fun FormCheckMail(){
    var mail by remember { mutableStateOf("") }
    var textSuccess by remember { mutableStateOf("") }
    var errorEmail = stringResource(id = R.string.erroremail)
    var errorText = stringResource(id = R.string.errortext)
    var enterButton = stringResource(id = R.string.enter_button)
    var welcomeMessage = stringResource(id = R.string.welcomeMessage)
    var name = stringResource(id = R.string.app_name)
    var isError by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = name,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            value = mail,
            onValueChange = { mail = it },
            label = {
                Text(
                    text = stringResource(
                        id = R.string.mail
                    )
                )
            },
        )
        if (textSuccess.isNotEmpty()) {
            if (!isError) {
                Text(
                    text = textSuccess,
                    color = Green
                )
            } else {
                Text(
                    text = textSuccess,
                    color = Red
                )
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue,   // màu nền
                contentColor = White      // màu chữ
            ),
            onClick = {
                when {
                    mail.isNullOrEmpty() -> {
                        textSuccess = errorText
                        isError = true
                    }
                    !mail.contains("@") -> {
                        textSuccess = "Email phải chứa ký tự '@'"
                        isError = true
                    }
                    !isValidEmail(mail) -> {
                        textSuccess = errorEmail
                        isError = true
                    }
                    else -> {
                        textSuccess = welcomeMessage
                        isError = false
                    }
                }
            }
        ) {
            Text(enterButton,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold)
        }
    }

}
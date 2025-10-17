package com.example.ungdunghienuicoban.ui.screen

import androidx.compose.foundation.Image
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

import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ungdunghienuicoban.R
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.Red
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.em
import com.example.ungdunghienuicoban.ui.theme.Poppins

@Composable
fun Textdetail(onBack: () -> Unit,){
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
                    verticalArrangement = Arrangement.Top
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
                                text = "Text Detail",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                color = Blue
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    // Text cơ bản
                    Text(text = "Test cơ bản") // text cơ bản

                    // Text có style trực tiếp
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Text với style",
                        color = Red,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        // (.Thin .ExtraLight .Light .Medium .SemiBold .Bold .ExtraBold .Black)
                        fontStyle = FontStyle.Italic,
                        // (.Normal .Italic)
                        textAlign = TextAlign.Left
                        // (.Left .Center .Right .Justify .Start .End)
                    ) // text với style

                    // Text với TextStyle riêng
                    val myTextStyle = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        lineHeight = 22.sp
                    )

                    Text(text = "Text với TextStyle", style = myTextStyle) // TextStyle

                    // Text có nhiều style trong cùng dòng
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.Red,
                                fontWeight = FontWeight.Bold
                            )
                            ) {
                                append("Một dòng text, ")
                            }
                            withStyle(style = SpanStyle(
                                color = Color.Blue,
                                fontStyle = FontStyle.Italic
                            )
                            ) {
                                append("Nhiều kiểu!")
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    ) // buildAnnotatedString + withStyle


                    // Text kiểu link (API mới thay cho ClickableText)
                    val annotatedText = buildAnnotatedString {
                        append("Đọc thêm về ")

                        withLink(
                            LinkAnnotation.Url("https://developer.android.com/jetpack/compose")
                        ) {
                            withStyle(
                                SpanStyle(
                                    color = Color(0xFF1976D2),
                                    textDecoration = TextDecoration.Underline,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append("Jetpack Compose")
                            }
                        }
                    }

                    Text(
                        text = annotatedText,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center
                    )

                    // Xử lý khi text quá dài
                    Text(
                        text = "Gửi thông báo xử lý vi phạm qua hình ảnh cho gần 1.900 trường hợp chủ xe và người vi phạm, trong đó vi phạm về tốc độ gần 900 trường hợp; chạy trên vỉa hè gần 400 trường hợp; dừng xe, đỗ xe không đúng quy định hơn 520 trường hợp…",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis // Hiển thị dấu "..."
                    )

                    val demo = buildAnnotatedString {
                        // "The " bình thường
                        append("The ")

                        // "~quick~" gạch ngang
                        withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                            append("quick")
                        }

                        append(" ")

                        // "Brown" đậm + đổi màu
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB36A00) // nâu/cam
                            )
                        ) { append("Brown") }

                        append("\n\n")

                        // "fox jumps" với chữ thưa
                        append("fox ")
                        withStyle(SpanStyle(letterSpacing = 0.2.em)) {
                            append("jumps")
                        }
                        append(" ")

                        // "over" đậm
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("over")
                        }

                        append("\n\n")

                        // "the" gạch chân
                        withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("the")
                        }
                        append(" ")

                        // "lazy" nghiêng
                        withStyle(SpanStyle(fontStyle = FontStyle.Italic,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp)) {
                            append("lazy")
                        }
                        append(" dog.")
                    }

                    Text(
                        text = demo,
                        modifier = Modifier.fillMaxWidth(),
                        style = TextStyle(fontSize = 20.sp, lineHeight = 28.sp)
                    )
                }
            }
        }
    }
}
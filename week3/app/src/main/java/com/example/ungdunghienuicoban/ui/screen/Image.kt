package com.example.ungdunghienuicoban.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ungdunghienuicoban.R
import com.example.ungdunghienuicoban.ui.theme.Blue
import com.example.ungdunghienuicoban.ui.theme.UngdunghienuicobanTheme

@Composable
fun Image(onBack: () -> Unit,){
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
                                text = "Images",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                color = Blue
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    // ảnh lấy về trên mạng
                    UrlImageSample()
                    Text(text ="From URL",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)

                    Spacer(modifier = Modifier.height(30.dp))

                    // ảnh trong app
                    Image(
                        painter = painterResource(id = R.drawable.trg),
                        contentDescription = "Profile picture",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = "In App",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(30.dp))

                    // tạo ảnh bằng code
                    // ImageVector: bạn tự tạo một “hình vector” bằng code (đường path, line, curve…), rồi nhét vào Image. Giống như bạn có một file SVG nhưng viết bằng Kotlin. Ưu điểm: nét không vỡ khi phóng to, nhẹ, đổi màu dễ.
                    // Canvas: bạn không dùng Image nữa mà vẽ trực tiếp (hình tròn, chữ nhật, đường cong…) lên một vùng. Dùng khi cần đồ họa linh hoạt: badge, rings, progress tùy biến, watermark, skeleton…
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        VectorLightning()
                        CanvasBadge()
                    }
                    Text(text = "By code",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)

                }
            }
        }
    }
}

//implementation(platform("io.coil-kt:coil-bom:2.7.0"))
//    implementation("io.coil-kt:coil-compose")
@Composable
fun UrlImageSample() {
    val url =
        "https://tuyensinhhuongnghiep.vn/upload/images/2023/09/08/truong-dai-hoc-giao-thong-van-tai-tphcm.jpg"

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = "ĐH Giao thông Vận tải TP.HCM",
        contentScale = ContentScale.Crop,
        placeholder = painterResource(R.drawable.img), // tùy chọn
        error = painterResource(R.drawable.img),             // tùy chọn
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f)
            .clip(RoundedCornerShape(16.dp))
    )

}

@Composable
fun VectorLightning(modifier: Modifier = Modifier) {
    // Tạo một icon "tia sét" đơn giản
    val lightning = remember {
        ImageVector.Builder(
            name = "Lightning",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            // Path giống như d vẽ trong SVG
            path(fill = SolidColor(Color(0xFFFFC107))) {
                moveTo(13f, 2f)
                lineTo(4f, 14f)
                lineTo(11f, 14f)
                lineTo(10f, 22f)
                lineTo(20f, 9f)
                lineTo(13f, 9f)
                close()
            }
        }.build()
    }

    // Chuyển vector thành painter rồi dùng Image hiển thị
    val painter = rememberVectorPainter(image = lightning)

    Image(
        painter = painter,
        contentDescription = "Lightning",
        modifier = modifier.size(64.dp)
    )
}

@Composable
fun CanvasBadge(modifier: Modifier = Modifier) {
    Canvas(
        modifier = modifier
            .size(80.dp)
            .padding(4.dp)
    ) {
        // Nền tròn
        drawCircle(color = Color(0xFF1976D2))

        // Viền nhẫn
        drawCircle(
            color = Color.White,
            radius = size.minDimension / 2.4f,
            style = Stroke(width = 6f)
        )

        // Vạch chéo
        drawLine(
            color = Color.White,
            start = Offset(x = size.width * .25f, y = size.height * .25f),
            end   = Offset(x = size.width * .75f, y = size.height * .75f),
            strokeWidth = 8f,
            cap = StrokeCap.Round
        )
    }
}


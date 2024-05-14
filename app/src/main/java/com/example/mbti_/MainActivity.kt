package com.example.mbti_

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti_.ui.theme.MBTI_screenchangeTheme
//Greeting관련지점 지우고
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTI_screenchangeTheme {
                MainScreen()

            }
        }

    }

    @Preview
    @Composable
    fun MainScreen(){
        val context = LocalContext.current
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(color = Color.Unspecified
        )) {
            Spacer(modifier = Modifier.height(8.dp))

            intjdesc()
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                val intent = Intent(context, INTJ_Activity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier.size(104.dp,32.dp,)){
                Text(text = "상세보기", fontSize = 12.sp)
            }

            blank()

            intpdesc()
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                val intent = Intent(context, INTP_Activity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier.size(104.dp,32.dp,)){
                Text(text = "상세보기", fontSize = 12.sp)
            }

            blank()

            entpdesc()
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {
                val intent = Intent(context, ENTP_Activity::class.java)
                context.startActivity(intent)
            }, modifier = Modifier.size(104.dp,32.dp,)){
                Text(text = "상세보기", fontSize = 12.sp)
            }
        }

    }
    @Composable
    fun blank(){
        Spacer(modifier = Modifier.height(16.dp))
        Divider(
            color = Color.Black.copy(alpha = 0.2f),
            modifier = Modifier
                .padding(horizontal = 80.dp),
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

    @Composable
    fun intjdesc(){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "성격유형", modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "분석가형", modifier = Modifier.fillMaxWidth(),
                fontSize = 32.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                color = Color.DarkGray)
            Image(painter = painterResource(id = R.drawable.intj), contentDescription = "intg image")
            Text(text = "전략가", modifier = Modifier.fillMaxWidth(),
                fontSize = 8.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
            Text(text = "INTJ-A / INTJ - T", modifier = Modifier.fillMaxWidth(),
                fontSize = 8.sp, textAlign = TextAlign.Center)
            Text(text = "모든 일에 대해 계획을 세우며 상상력이 풍부한 전략가 입니다.", modifier = Modifier.fillMaxWidth(),
                fontSize = 6.sp, textAlign = TextAlign.Center, color = Color.DarkGray)


        }
    }
    @Composable
    fun intpdesc() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.intp),
                contentDescription = "intg image", contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize(0.5f)
            )
            Text(
                text = "논리술사", modifier = Modifier.fillMaxWidth(),
                fontSize = 8.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
            )
            Text(
                text = "INTP-A / INTP - T", modifier = Modifier.fillMaxWidth(),
                fontSize = 8.sp, textAlign = TextAlign.Center
            )
            Text(
                text = "모든 일에 대해 계획을 세우며 상상력이 풍부한 전략가 입니다.", modifier = Modifier.fillMaxWidth(),
                fontSize = 6.sp, textAlign = TextAlign.Center, color = Color.DarkGray
            )

        }
    }
    @Composable
    fun entpdesc() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Image(
                painter = painterResource(id = R.drawable.entp),
                contentDescription = "intg image", contentScale = ContentScale.FillHeight, modifier = Modifier.fillMaxSize(0.5f)
            )
            Text(
                text = "논리술사", modifier = Modifier.fillMaxWidth(),
                fontSize = 8.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center
            )
            Text(
                text = "ENTP-A / ENTP - T", modifier = Modifier.fillMaxWidth(),
                fontSize = 8.sp, textAlign = TextAlign.Center
            )
            Text(
                text = "지적 도전을 즐기는 영리하고 호기심이 많은 사색가입니다.", modifier = Modifier.fillMaxWidth(),
                fontSize = 6.sp, textAlign = TextAlign.Center, color = Color.DarkGray
            )

        }
    }

}

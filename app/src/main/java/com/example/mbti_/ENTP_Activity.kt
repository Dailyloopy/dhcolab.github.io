package com.example.mbti_

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mbti_.ui.theme.MBTI_screenchangeTheme

class ENTP_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MBTI_screenchangeTheme {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val context = LocalContext.current as? Activity
                    Text(text = "ENTP 특징", fontSize = 40.sp, modifier = Modifier.padding(10.dp))

                    Image(painter = painterResource(id = R.drawable.enptdesc), contentDescription = null,
                        contentScale = ContentScale.FillBounds)

                    Button(onClick = {
                        val intent = Intent(context, MainActivity::class.java)
                        context?.startActivity(intent)
                    }){
                        Text(text = "닫기")
                    }
                }

            }
        }
    }
}
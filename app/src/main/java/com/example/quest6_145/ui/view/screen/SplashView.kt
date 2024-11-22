package com.example.quest6_145.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quest6_145.R

@Composable
fun SplashView(
    onMulaiButton: ()->Unit,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(
                    id = R.color.primary
                )
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Selamat Datang!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(
            modifier = Modifier
                .padding(15.dp)
        )
        Image(
            painter = painterResource(
                id = R.drawable.umy
            ),
            contentDescription = "", modifier = Modifier.size(200.dp)
        )
        Spacer(
            modifier = Modifier
                .padding(15.dp)
        )
        Text(
            text = "Tekan untuk mulai",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Button(
            onClick = { onMulaiButton() },
            modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow)
            ){
            Text(
                text = "Mulai",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black)
        }
    }
}
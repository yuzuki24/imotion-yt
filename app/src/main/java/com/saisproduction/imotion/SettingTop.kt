package com.saisproduction.imotion


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SettingTop(onNavigation:(Int) -> Unit){
    val units = AllUnit.getUNITS()
    LazyColumn(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, // 横方向
        verticalArrangement = Arrangement.Center // 縦方向
        ) {
        items(items=units) {units->
            Button(
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White,
                    disabledContentColor = Color.LightGray
                ),
                onClick = { onNavigation(units.UNIT_ID) },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(top = 100.dp)
                    .size(width = 280.dp, height = 200.dp)
                    .border(
                        width = 15.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )

            ) {
                Text(
                    text = units.UNIT_NAME,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Monospace
                )
                //インサートから引っ張る。units.UNIT_NAME
            }
        }


    }

}
package com.saisproduction.imotion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.ui.platform.LocalUriHandler


@Composable
fun Individual( MEMBER_ID: Int) {
    //UNIT_IDがメンバーのUNIT_IDと一致したものだけをメンバー一覧に表示
    val members = AllMembers.getMEMBERS().find {  it.MEMBER_ID == MEMBER_ID} ?: return
    val handler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()

    ) {

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(3) {
                Image(
                    painter = painterResource(id = R.drawable.earthace),
                    contentDescription = null,
                    modifier = Modifier
                        .size(500.dp)
                    //contentAlignment = Alignment.Center
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .padding(all = 15.dp)
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            items(items=listOf(members)) { MEMBER_ID ->
                Text(text = MEMBER_ID.FAMILY_NAME + MEMBER_ID.LAST_NAME,
                    color = Color(0xffee7700), fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,modifier = Modifier.padding(top = 8.dp))
                Text(text = "ニックネーム",color = Color(0xffee7700),modifier = Modifier.padding(top = 8.dp))
                Text(text= MEMBER_ID.DISPLAY_NAME,modifier = Modifier.padding(top = 8.dp))
                Text(text = "プロフィール", color = Color(0xffee7700),modifier = Modifier.padding(top = 8.dp))
                Text(text = MEMBER_ID.PROFILE,modifier = Modifier.padding(top = 8.dp))
                Text(text = "記事",
                    color = Color(0xffee7700),modifier = Modifier.padding(top = 8.dp))
                Text(text = MEMBER_ID.ARTICLE,modifier = Modifier.padding(top = 8.dp))
                IconButton(
                    onClick = { handler.openUri("https://twitter.com/r_earthace_s")},
                    modifier = Modifier.padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.twitter_icon),
                        contentDescription = "Twitterアイコン",
                        modifier = Modifier.fillMaxSize(),
                        //colorFilter = ColorFilter.tint(Color.White)
                    )
                }
            }
        }
    }
}
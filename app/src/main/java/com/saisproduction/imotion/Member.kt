package com.saisproduction.imotion


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Member(unitId: String, onNavigation: (Int) -> Unit) {
    //val members = AllMembers.getMEMBERS(unitId)
    //val members = AllMembers.getMEMBERS().toList().firstOrNull { it.UNIT_ID.toString() == unitId }

    val members = AllMembers.getMEMBERS().filter { it.UNIT_ID.toString() == unitId }

    if (members.isEmpty()) {
        Text(text = "メンバーが見つかりませんでした")
    } else {


        LazyColumn(
            modifier = Modifier
                //.clickable { onNavigation() }
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(5.dp)
                )) {
            //Text(text = "メンバー", fontSize = 30.sp, style = TextStyle(color=Color.Magenta))

            items(members) { members ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable { onNavigation(members.MEMBER_ID) }
                        .fillMaxWidth()
                    //.background(Color.Yellow, RoundedCornerShape(5.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.earthace),
                        contentDescription = null,
                        modifier = Modifier
                            .size(190.dp)
                            .clickable { onNavigation(members.MEMBER_ID) }
                            .padding(top = 20.dp)
                    )
                    Text(text = members.FAMILY_NAME + members.LAST_NAME, fontSize = 25.sp,
                        modifier = Modifier
                            .padding(start = 15.dp)
                    )

                }


            }


        }

    }
    }
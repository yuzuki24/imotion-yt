package com.saisproduction.imotion

import androidx.room.Entity
import androidx.room.PrimaryKey


@Suppress("unused")
@Entity
class MEMBERS(
    @PrimaryKey(autoGenerate = true)
    val MEMBER_ID: Int,
    val UNIT_ID: Int,
    val FAMILY_NAME: String,
    //val MIDDLE_NAME: String,
    val LAST_NAME: String,
    val DISPLAY_NAME: String,
    //val FAMILY_NAME_EN: String,
    //val MIDDLE_NAME_EN: String,
    //val LAST_NAME_EN: String,
    val MEMBER_IMAGE_MAIN: Int,
    val PROFILE: String,
    val ARTICLE: String,
    //val ENTER_DATE: Any,
    //val EXIT_DATE: Any
){

}

object AllMembers {

    fun getMEMBERS(): List<MEMBERS> = member

}

//object AllMembers {
  //  private val members = mutableListOf<MEMBERS>()

    //fun getMEMBERS(unitId: String): List<MEMBERS> {
        // unitIdに一致するデータのみを返す
      //  return members.filter { it.UNIT_ID == unitId.toIntOrNull() }
    //}

    // 以下略
//}
//テスト用データ

private val member1 = MEMBERS(
    MEMBER_ID = 1,
    UNIT_ID = 1,
    FAMILY_NAME = "いわや",
    LAST_NAME = "りか",
    DISPLAY_NAME = "りか" ,
    MEMBER_IMAGE_MAIN =  R.drawable.earthace,
    PROFILE ="誕生日：\nメンバーカラー：",
    ARTICLE ="よろしくお願いします！"
)

private val member2 = MEMBERS(
    MEMBER_ID = 2,
    UNIT_ID = 1,
    FAMILY_NAME = "",
    LAST_NAME = "あすみ",
    DISPLAY_NAME = "あすみ" ,
    MEMBER_IMAGE_MAIN =  R.drawable.earthace,
    PROFILE ="誕生日：\nメンバーカラー：",
    ARTICLE ="よろしくお願いします！"

)

private val member3 = MEMBERS(
    MEMBER_ID = 3,
    UNIT_ID = 1,
    FAMILY_NAME = "田中",
    LAST_NAME = "美卯",
    DISPLAY_NAME = "田中美卯" ,
    MEMBER_IMAGE_MAIN =  R.drawable.earthace,
    PROFILE ="誕生日：\nメンバーカラー：",
    ARTICLE ="よろしくお願いします！"

)

private val member4 = MEMBERS(
    MEMBER_ID = 4,
    UNIT_ID = 1,
    FAMILY_NAME = "渡邊",
    LAST_NAME = "紗季",
    DISPLAY_NAME = "渡邊紗季",
    MEMBER_IMAGE_MAIN =  R.drawable.earthace,
    PROFILE ="誕生日：\nメンバーカラー：",
    ARTICLE ="よろしくお願いします！"

)

//"ほやっこ"
private val member5= MEMBERS(
    MEMBER_ID = 5,
    UNIT_ID = 2,
    FAMILY_NAME = "田中",
    LAST_NAME = "美卯",
    DISPLAY_NAME = "田中美卯" ,
    MEMBER_IMAGE_MAIN =  R.drawable.earthace,
    PROFILE ="誕生日：\nメンバーカラー：",
    ARTICLE ="よろしくお願いします！"

)

private val member6 = MEMBERS(
    MEMBER_ID = 6,
    UNIT_ID = 2,
    FAMILY_NAME = "渡邊",
    LAST_NAME = "紗季",
    DISPLAY_NAME = "渡邊紗季",
    MEMBER_IMAGE_MAIN =  R.drawable.earthace,
    PROFILE ="誕生日：\nメンバーカラー：",
    ARTICLE ="よろしくお願いします！"

)


//private val member = listOf(
 //   member1, member2, member3, member4,member5,member6
//)
//object AllMembers {
    private val member = listOf(
        member1, member2, member3, member4, member5, member6
    )

    //fun getMEMBERS(unitId: String): List<MEMBERS> {
        // unitIdに一致するデータのみを返す
      //  return members.filter { it.UNIT_ID == unitId.toIntOrNull() }
    //}
//}

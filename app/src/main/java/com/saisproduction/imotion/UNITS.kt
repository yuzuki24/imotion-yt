package com.saisproduction.imotion

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UNITS(
    @PrimaryKey(autoGenerate = true)
    val UNIT_ID: Int,
    val UNIT_NAME:String,
    //var UNIT_IMAGE_MAIN: Blob,
    //var START_DATE: Long,
    //var END_DATE:Date,
    //var ORDER:Int,
    //var MOVIE_URI:String,
    //var SNS_URI:String,
    //var HP_URI:String
) {

}

object AllUnit {

    fun getUNITS(): List<UNITS> = unit

}

//ユニットデータ

private val unit1 = UNITS(
    UNIT_ID = 1,
    UNIT_NAME = "EarthAce-SND"
)

private val unit2 = UNITS(
    UNIT_ID = 2,
    UNIT_NAME = "ほやっこ"
)



private val unit = listOf(
    unit1, unit2
)


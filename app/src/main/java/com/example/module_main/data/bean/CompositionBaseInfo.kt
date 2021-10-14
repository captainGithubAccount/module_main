package com.example.module_main.data.bean

import androidx.recyclerview.widget.DiffUtil

data class ComPositionBaseInfoList(
    val error_code: Int,
    val reason: String,
    //当每日的api请求次数上限的时候会返回null
    val result: ResultComposition?

)

data class ResultComposition(
    val list: List<CompositionInfo>,
    val page: Int,
    val size: Int,
    val totalCount: Int
)

data class CompositionInfo(
    val gradeId: Int,
    val id: Int,
    val level: Int,
    val name: String,
    val time: String,
    val typeId: Int,
    val wordId: Int,
    val writer: String
)
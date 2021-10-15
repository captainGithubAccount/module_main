package com.example.module_main.data.bean
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

import androidx.recyclerview.widget.DiffUtil

@Parcelize
data class ComPositionBaseInfoList(
    val error_code: Int,
    val reason: String,
    //当每日的api请求次数上限的时候会返回null
    val result: ResultComposition?

) : Parcelable

@Parcelize
data class ResultComposition(
    val list: List<CompositionInfo>,
    val page: Int,
    val size: Int,
    val totalCount: Int
) : Parcelable

@Parcelize
data class CompositionInfo(
    val gradeId: Int,
    val id: Int,
    val level: Int,
    val name: String,
    val time: String,
    val typeId: Int,
    val wordId: Int,
    val writer: String
) : Parcelable




@Parcelize
data class CompositionContentInfo(
    val error_code: Int,
    val reason: String,
    val result: CompositionContent?
) : Parcelable

@Parcelize
data class CompositionContent(
    val comment: String,
    val content: String,
    val id: Int,
    val school: String,
    val teacher: String
) : Parcelable
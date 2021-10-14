package com.example.module_main.data.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class NewsBean(
    val error_code: Int,
    val reason: String,
    val result: Result?
) : Parcelable

@Parcelize
data class Result(
    val `data`: List<Data>,
    val page: String,
    val pageSize: String,
    val stat: String
) : Parcelable

@Parcelize
data class Data(
    val author_name: String?,
    val category: String?,
    val date: String?,
    val is_content: String?,
    val thumbnail_pic_s: String?,
    val thumbnail_pic_s02: String?,
    val thumbnail_pic_s03: String?,
    val title: String?,
    val uniquekey: String?,
    val url: String?
) : Parcelable

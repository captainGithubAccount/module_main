package com.example.module_main.data.bean
//一、新闻api
//1、新闻对api对应的key
const val KEY= "3f64601cc5c4b59a7a3abe727a200858"
//1.1、搜索新闻的base url
const val BASE_URL_INFO = "http://v.juhe.cn/toutiao/index?key=${KEY}&type="
//1.1.1、各个新闻主题对应的完整url
const val URL_GAME = "${BASE_URL_INFO}youxi"
const val URL_HEALTHY = "${BASE_URL_INFO}jiankang"
const val URL_MILITARY = "${BASE_URL_INFO}junshi"
const val URL_REST = "${BASE_URL_INFO}top"
const val URL_SCIENCE = "${BASE_URL_INFO}keji"
const val URL_SPORTS = "${BASE_URL_INFO}tiyu"

//二、作文api对应的key
const val KEY_COMPOSITION= "374823b7aec9f1207c1c85a3e04e0f73"
//1、通过作文年级来搜索作文列表信息的base url
const val BASE_URL_INFO_COMPOSITION_GRADE = "http://zuowen.api.juhe.cn/zuowen/baseList?key=${KEY_COMPOSITION}&gradeId="
//1.1、各个年级对应的url参数id
//1.1.1、一年级
const val URL_EXPLORE_ONE_GRADE = "11"
//1.1.2、二年级
const val URL_EXPLORE_TWO_GRADE = "12"
//1.1.3、三年级
const val URL_EXPLORE_THREE_GRADE = "13"
//1.1.4、四年级
const val URL_EXPLORE_FOUR_GRADE = "14"
//1.1.5、五年级
const val URL_EXPLORE_FIVE_GRADE = "15"
//1.1.6、六年级
const val URL_EXPLORE_SIX_GRADE = "16"
//1.2、通过作文主题来搜索作文列表信息的base url
const val BASE_URL_INFO_COMPOSITION_THEME = "http://zuowen.api.juhe.cn/zuowen/baseList?key=${KEY_COMPOSITION}&typeId="
//1.2.1、说明文
const val URL_SHUO_MING_WEN = "16"

//2、搜索作文内容信息的 base url
const val BASE_URL_COMPOSITION_CONTENT = "http://zuowen.api.juhe.cn/zuowen/content?key=${KEY_COMPOSITION}&id="










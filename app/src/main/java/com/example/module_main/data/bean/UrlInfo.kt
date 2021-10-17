package com.example.module_main.data.bean
//一、新闻api
//1、新闻api对应的key
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

//二、作文api
//1、作文api对应的key
const val KEY_COMPOSITION= "374823b7aec9f1207c1c85a3e04e0f73"
//1.1、通过作文年级来搜索作文列表信息的base url
const val BASE_URL_INFO_COMPOSITION_GRADE = "http://zuowen.api.juhe.cn/zuowen/baseList?key=${KEY_COMPOSITION}&gradeId="
//1.1.1、各个年级对应的url参数id
//一年级
const val URL_EXPLORE_ONE_GRADE = "11"
//二年级
const val URL_EXPLORE_TWO_GRADE = "12"
//三年级
const val URL_EXPLORE_THREE_GRADE = "13"
//四年级
const val URL_EXPLORE_FOUR_GRADE = "14"
//五年级
const val URL_EXPLORE_FIVE_GRADE = "15"
//六年级
const val URL_EXPLORE_SIX_GRADE = "16"
//小升初
const val URL_XIAO_SHENG_CHU = "17"
//初一
const val URL_CHUYI ="21"
//初二
const val URL_CHUER ="22"
//初三
const val URL_CHUSAN ="23"
//中考
const val URL_ZHONGKAO = "24"
//高一
const val URL_GAOYI ="31"
//高二
const val URL_GAOER ="32"
//高三
const val URL_GAOSAN ="33"
//高考
const val URL_GAOKAO ="34"


//1.2、通过作文主题来搜索作文列表信息的base url
const val BASE_URL_INFO_COMPOSITION_THEME = "http://zuowen.api.juhe.cn/zuowen/baseList?key=${KEY_COMPOSITION}&typeId="
//1.2.1、各个主题对应的url参数id
//看图
const val URL_KANTU = "34"
//游记
const val URL_YOUJI = "31"
//叙事
const val URL_XUSHI = "12"
//其他
const val URL_OTHERS = "40"
//状物
const val URL_ZHUANGWU = "14"
//诗歌
const val URL_SHIGE = "29"
//写人
const val URL_XIEREN = "11"
//写景
const val URL_XIEJING = "13"
//童话
const val URL_TONGHUA = "25"
//散文
const val URL_SANWEN = "26"
//议论文
const val URL_YILUNWEN = "15"
//读后感
const val URL_DUHOUGAN = "21"
//日记
const val URL_RIJI = "18"
//寓言
const val URL_YUYAN = "28"
//说明文
const val URL_SHUO_MING_WEN = "16"
//读书笔记
const val URL_NODES_DUSHU = "32"
//话题
const val URL_HUATI = "36"
//想象
const val URL_XIANGXIANG = "35"
//演讲稿
const val URL_YANJIANGGAO = "22"
//应用文
const val URL_YINGYONGWEN = "50"
//书信
const val URL_SHUXING = "17"
//小说
const val URL_XIAOSHUO = "4"

//2、搜索作文内容信息的 base url
const val BASE_URL_COMPOSITION_CONTENT = "http://zuowen.api.juhe.cn/zuowen/content?key=${KEY_COMPOSITION}&id="










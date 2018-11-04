package com.wjl.kotlinexercise

/**
 * author: WuJinLi
 * time  : 2018/9/8
 * desc  : 项目常量类
 */
object Constant {
    //    const val BASE_URL: String = "http://baobab.kaiyanapp.com/api/"
    const val BASE_URL: String = "http://op.juhe.cn/onebox/"
    const val REQUEST_INIT: Int = 0x00
    const val REQUEST_REFRESH: Int = 0x01
    const val REQUEST_LOAD_MORE: Int = 0x02


    //和风天气测试数据配置信息
    const val APP_KEY: String = "52dc04b1b08a43dc9f51325a5b5cb87b"
    const val HEWIND_BASE_URL = "https://search.heweather.com/"


    const val URL = "https://free-api.heweather.com/s6/weather/forecast?location=北京&key=52dc04b1b08a43dc9f51325a5b5cb87b"


    /******************************************开眼接口**************************************************/

    // 所有分类
    const val ALLCATEGORY_URL = "http://baobab.kaiyanapp.com/api/v4/categories/all"

    //分类
    const val CATEGORY_URL = "http://baobab.kaiyanapp.com/api/v5/category/list"


    //发现
    const val DISCOVERY_URL = "http://baobab.kaiyanapp.com/api/v5/index/tab/discovery"

    const val API_PREFIX_URL = "http://baobab.kaiyanapp.com/api/v5/index/tab/"
}
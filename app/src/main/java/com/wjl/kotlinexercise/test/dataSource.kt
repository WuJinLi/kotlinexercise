package com.wjl.kotlinexercise.test

import java.io.Serializable

/**
 * author: WuJinLi
 * time  : 2018/10/16
 * desc  :
 */
data class HeWeather6Model(var HeWeather6: List<HeWeather6Bean>) : Serializable


data class HeWeather6Bean(var basic: BasicBean,
                          var update: UpdateBean,
                          var status: String,
                          var daily_forecast: List<DailyForecastBean>) : Serializable


data class BasicBean(var cid: String,
                     var location: String,
                     var parent_city: String,
                     var admin_area: String,
                     var cnty: String,
                     var lat: String,
                     var lon: String,
                     var tz: String) : Serializable

data class UpdateBean(var loc: String,
                      var utc: String) : Serializable

data class DailyForecastBean(var cond_code_d: String,
                             var cond_code_n: String,
                             var cond_txt_d: String,
                             var cond_txt_n: String,
                             var date: String,
                             var hum: String?,
                             var mr: String,
                             var ms: String,
                             var pcpn: String,
                             var pop: String,
                             var pres: String,
                             var sr: String,
                             var ss: String,
                             var tmp_max: String,
                             var tmp_min: String,
                             var uv_index: String,
                             var vis: String,
                             var wind_deg: String,
                             var wind_dir: String?,
                             var wind_sc: String,
                             var wind_spd: String) : Serializable
package com.wjl.kotlinexercise.test

import com.google.gson.annotations.SerializedName

/**
 * author: WuJinLi
 * time  : 2018/10/16
 * desc  :
 */
class HeWeather6Model {

    @SerializedName("HeWeather6")
    var heWeather6: List<HeWeather6Bean>? = null

    class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101010100","location":"北京","parent_city":"北京","admin_area":"北京","cnty":"中国","lat":"39.90498734","lon":"116.4052887","tz":"+8.00"}
         * update : {"loc":"2018-10-16 13:45","utc":"2018-10-16 05:45"}
         * status : ok
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"100","cond_txt_d":"多云","cond_txt_n":"晴","date":"2018-10-16","hum":"58","mr":"13:04","ms":"22:52","pcpn":"0.0","pop":"1","pres":"1023","sr":"06:26","ss":"17:31","tmp_max":"17","tmp_min":"7","uv_index":"3","vis":"18","wind_deg":"357","wind_dir":"北风","wind_sc":"1-2","wind_spd":"7"},{"cond_code_d":"100","cond_code_n":"101","cond_txt_d":"晴","cond_txt_n":"多云","date":"2018-10-17","hum":"37","mr":"13:48","ms":"23:46","pcpn":"0.0","pop":"25","pres":"1026","sr":"06:27","ss":"17:30","tmp_max":"17","tmp_min":"5","uv_index":"6","vis":"20","wind_deg":"1","wind_dir":"北风","wind_sc":"1-2","wind_spd":"11"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2018-10-18","hum":"25","mr":"14:27","ms":"00:00","pcpn":"0.0","pop":"2","pres":"1029","sr":"06:28","ss":"17:29","tmp_max":"18","tmp_min":"6","uv_index":"3","vis":"20","wind_deg":"181","wind_dir":"南风","wind_sc":"1-2","wind_spd":"2"}]
         */

        @SerializedName("basic")
        var basic: BasicBean? = null
        @SerializedName("update")
        var update: UpdateBean? = null
        @SerializedName("status")
        var status: String? = null
        @SerializedName("daily_forecast")
        var dailyForecast: List<DailyForecastBean>? = null

        class BasicBean {
            /**
             * cid : CN101010100
             * location : 北京
             * parent_city : 北京
             * admin_area : 北京
             * cnty : 中国
             * lat : 39.90498734
             * lon : 116.4052887
             * tz : +8.00
             */

            @SerializedName("cid")
            var cid: String? = null
            @SerializedName("location")
            var location: String? = null
            @SerializedName("parent_city")
            var parentCity: String? = null
            @SerializedName("admin_area")
            var adminArea: String? = null
            @SerializedName("cnty")
            var cnty: String? = null
            @SerializedName("lat")
            var lat: String? = null
            @SerializedName("lon")
            var lon: String? = null
            @SerializedName("tz")
            var tz: String? = null
        }

        class UpdateBean {
            /**
             * loc : 2018-10-16 13:45
             * utc : 2018-10-16 05:45
             */

            @SerializedName("loc")
            var loc: String? = null
            @SerializedName("utc")
            var utc: String? = null
        }

        class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 100
             * cond_txt_d : 多云
             * cond_txt_n : 晴
             * date : 2018-10-16
             * hum : 58
             * mr : 13:04
             * ms : 22:52
             * pcpn : 0.0
             * pop : 1
             * pres : 1023
             * sr : 06:26
             * ss : 17:31
             * tmp_max : 17
             * tmp_min : 7
             * uv_index : 3
             * vis : 18
             * wind_deg : 357
             * wind_dir : 北风
             * wind_sc : 1-2
             * wind_spd : 7
             */

            @SerializedName("cond_code_d")
            var condCodeD: String? = null
            @SerializedName("cond_code_n")
            var condCodeN: String? = null
            @SerializedName("cond_txt_d")
            var condTxtD: String? = null
            @SerializedName("cond_txt_n")
            var condTxtN: String? = null
            @SerializedName("date")
            var date: String? = null
            @SerializedName("hum")
            var hum: String? = null
            @SerializedName("mr")
            var mr: String? = null
            @SerializedName("ms")
            var ms: String? = null
            @SerializedName("pcpn")
            var pcpn: String? = null
            @SerializedName("pop")
            var pop: String? = null
            @SerializedName("pres")
            var pres: String? = null
            @SerializedName("sr")
            var sr: String? = null
            @SerializedName("ss")
            var ss: String? = null
            @SerializedName("tmp_max")
            var tmpMax: String? = null
            @SerializedName("tmp_min")
            var tmpMin: String? = null
            @SerializedName("uv_index")
            var uvIndex: String? = null
            @SerializedName("vis")
            var vis: String? = null
            @SerializedName("wind_deg")
            var windDeg: String? = null
            @SerializedName("wind_dir")
            var windDir: String? = null
            @SerializedName("wind_sc")
            var windSc: String? = null
            @SerializedName("wind_spd")
            var windSpd: String? = null
        }
    }
}

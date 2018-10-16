package com.wjl.kotlinexercise.api

import com.wjl.kotlinexercise.test.HeWeather6Model
import io.reactivex.Observable
import retrofit2.http.*


/**
 * @author: wjl
 * @date:2018/9/6
 */
interface ApiService {

    @GET()
    fun getWeatherData(@Url url:String):Observable<HeWeather6Model>
}
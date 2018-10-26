package com.wjl.kotlinexercise.api

import com.wjl.kotlinexercise.openeye.entity.HomeDataBean
import com.wjl.kotlinexercise.openeye.model.AllCategroyModel
import com.wjl.kotlinexercise.openeye.model.CategroyModel
import com.wjl.kotlinexercise.openeye.model.HomeDataEntity
import com.wjl.kotlinexercise.test.HeWeather6Model
import io.reactivex.Observable
import retrofit2.http.*


/**
 * @author: wjl
 * @date:2018/9/6
 */
interface ApiService {

    @GET()
    fun getWeatherData(@Url url: String): Observable<HeWeather6Model>


    /**
     * 获取全部总类接口
     */
    @GET()
    fun getAllCategroyData(@Url url:String): Observable<AllCategroyModel>


    /**
     * 侧划栏目录
     */
    @GET()
    fun getCategroyData(@Url url:String):Observable<CategroyModel>


    @GET()
    fun getCommonListData(@Url url:String):Observable<HomeDataBean>
}
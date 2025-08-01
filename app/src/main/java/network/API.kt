package network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface API {
    @GET("discovery/categories")
    fun getJson(): Call<Categories>

    @GET("discovery/categories")
    fun getJsonWithParams(@Query("head") head: String): Call<Categories>

    @GET("discovery/categories")
    fun getJsonWithParamsMap(@QueryMap map: QueryMap): Call<Categories>
}
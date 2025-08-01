package network

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.demoapp.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_net_work_test.*
import kotlinx.android.synthetic.main.activity_ok_http.*
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.HttpURLConnection
import java.util.concurrent.TimeUnit

class OkHttpActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "OkHttpActivity"
        private const val BASE_URL = "https://api.sunofbeaches.com/shop"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ok_http)

        OkHttpClient

        btn_ok_request?.setOnClickListener {
            getRequest()
        }
        btn_post?.setOnClickListener {
            postComment()
        }
        btn_upload_file?.setOnClickListener { uploadFile() }
        btn_retrofit_post?.setOnClickListener {
            getRequestRetrofit()
        }
        btn_retrofit_post_params?.setOnClickListener {
            getRequestRetrofitParams()
        }
    }

    private fun getRequestRetrofitParams() {
        val retrofit = Retrofit.Builder()
            .baseUrl("$BASE_URL/")
            .addConverterFactory(GsonConverterFactory.create()) //增加一个工厂转化器
            .build()
        val api = retrofit.create(API::class.java)
        val call = api.getJson()
        call.enqueue(object : retrofit2.Callback<Categories> {
            override fun onResponse(
                call: retrofit2.Call<Categories>,
                response: retrofit2.Response<Categories>
            ) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse: body: ${response.body()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<Categories>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }
        })
    }

    private fun getRequestRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl("$BASE_URL/")
            .addConverterFactory(GsonConverterFactory.create()) //增加一个工厂转化器
            .build()
        val api = retrofit.create(API::class.java)
        val call = api.getJson()
        call.enqueue(object : retrofit2.Callback<Categories> {
            override fun onResponse(
                call: retrofit2.Call<Categories>,
                response: retrofit2.Response<Categories>
            ) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    Log.d(TAG, "onResponse: body: ${response.body()}")
                }
            }

            override fun onFailure(call: retrofit2.Call<Categories>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }
        })

    }

    private fun uploadFile() {
        //要有客户端，类似于我们要有一个浏览器
//        val okhttpClient = OkHttpClient.Builder()
//            .connectTimeout(10000, TimeUnit.MILLISECONDS)
//            .build()
//        RequestBody.create()
//        MultipartBody.Builder().addFormDataPart()
//        val requestBody = "body参数".toRequestBody("application/json".toMediaTypeOrNull())
//        //创建请求内容
//        val request = Request
//            .Builder()
//            .post(requestBody)
//            .url("$BASE_URL/post/comment").build()
//        //利用http去创建任务
//        val task = okhttpClient.newCall(request)
//        //异步请求
//        task.enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                val code = response.code
//                Log.d(TAG, "onResponse: code=====$code + \n + body======${response.body?.string()}")
//            }
//        })
    }

    private fun postComment() {
        //要有客户端，类似于我们要有一个浏览器
        val okhttpClient = OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .build()
        val requestBody = "body参数".toRequestBody("application/json".toMediaTypeOrNull())
        //创建请求内容
        val request = Request
            .Builder()
            .post(requestBody)
            .url("$BASE_URL/post/comment").build()
        //利用http去创建任务
        val task = okhttpClient.newCall(request)
        task.execute()
        //异步请求
        task.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val code = response.code
                Log.d(TAG, "onResponse: code=====$code + \n + body======${response.body?.string()}")
            }
        })
    }

    fun getRequest() {
        //要有客户端，类似于我们要有一个浏览器
        val okhttpClient = OkHttpClient.Builder()
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .build()
        //创建请求内容
        val request = Request
            .Builder()
            .get()
            .url("$BASE_URL/discovery/categories").build()
        //利用http去创建任务
        val task = okhttpClient.newCall(request)
        //异步请求
        task.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                try {
                    val code = response.code
                    //Log.d(TAG, "onResponse: code=====$code + \n + body======${response.body?.string()}")
                    val gson = Gson()
                    val categories = gson.fromJson(response.body?.string(), Categories::class.java)
                    Log.d(TAG, "onResponse: categories=====${categories.message}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        })
    }
}



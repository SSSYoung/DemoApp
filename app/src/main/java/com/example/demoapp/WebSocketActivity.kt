package com.example.demoapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class WebSocketActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "WSDemo"
        private const val WS_URL = "ws://10.217.16.40:8765" // 改成你的服务端 IP
    }

    private val okHttp = OkHttpClient()
    private var webSocket: WebSocket? = null     // 保存连接，方便随时发送/关闭

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* 1. 建立连接 */
        val request = Request.Builder().url(WS_URL).build()
        webSocket = okHttp.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(ws: WebSocket, response: Response) {
                Log.i(TAG, "已连接")
                /* 2. 连上就发一句话测试 */
                ws.send("Hello from Android!")
            }

            override fun onMessage(ws: WebSocket, text: String) {
                Log.i(TAG, "收到服务器: $text")
            }

            override fun onClosing(ws: WebSocket, code: Int, reason: String) {
                Log.i(TAG, "连接关闭中 code=$code reason=$reason")
            }

            override fun onFailure(ws: WebSocket, t: Throwable, r: Response?) {
                Log.e(TAG, "连接失败: ${t.message}", t)
            }
        })

        /* （可选）再手动发一条 */
        webSocket?.send("Second message")
    }

    override fun onDestroy() {
        super.onDestroy()
        /* 3. 退出时关闭连接并释放线程池 */
        webSocket?.close(1000, "Activity finish")
        okHttp.dispatcher.executorService.shutdown()
    }
}
package com.example.demoapp.soa

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.desaysv.DDS.DDSChannelBuilder
import com.desaysv.DDS.DDSUtil
import com.desaysv.voice.ipc.GreeterGrpc
import com.desaysv.voice.ipc.GreeterGrpc.GreeterBlockingStub
import com.desaysv.voice.ipc.TtsRequest
import com.example.demoapp.R
import utils.ThreadUtils
import java.util.Arrays

class SoaActivity : AppCompatActivity() {
    private val TAG = "SoaActivity"
    private var blockingStub: GreeterBlockingStub? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soa)
        initDDS()
    }

    private fun initDDS() {
        blockingStub = GreeterGrpc.newBlockingStub(
            DDSChannelBuilder.forName("soa:voice_service").directExecutor()
                .build()
        )
    }

    override fun onStart() {
        super.onStart()
        val clientId = DDSUtil.geTopicInfo()
        Log.d(
            TAG,
            "onStart: $clientId"
        )

        // initConnectInfo
        val ContMessage: ByteArray = clientId.toByteArray()
        val SubLength = 4 + ContMessage.size
        val ContSubLength = DDSUtil.intToBytes(SubLength)
        val ContLength = DDSUtil.intToBytes(8 + SubLength)
        val ContMessageID = DDSUtil.intToBytes(0)
        val ContStreamID = DDSUtil.intToBytes(0)
        val connect = DDSUtil.mergeBytes(
            "dds".toByteArray(),
            ContLength,
            ContStreamID,
            ContSubLength,
            ContMessageID,
            ContMessage
        )
        Log.d(
            TAG,
            "客户端连接消息----字节=====" + Arrays.toString(connect)
        )
        Log.d(
            TAG,
            "客户端连接消息=====" + String(connect)
        )
        //
//        val dataInfo = DataInfo(
//            "soa:voice_service",
//            0,
//            connect
//        ) //组装Topic、数据
//
//        DDSUtils.getInstance().createPublisher(dataInfo) //发布数据

        ThreadUtils.executeOnBackground {
            val ttsRequest = TtsRequest.newBuilder().setContent("this is test string").build()
            val ttsReply = blockingStub?.playTts(ttsRequest)
            Log.d(
                TAG,
                "onStart, content: $ttsReply?.message"
            )
        }
    }


}
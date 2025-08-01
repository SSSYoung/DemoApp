package widgetlearn

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.R
import com.example.demoapp.databinding.ActivityBoardCastBinding
import kotlinx.android.synthetic.main.activity_board_cast.*
import widgetlearn.TestService.MyBinder

class WidgetTestActivity : AppCompatActivity() {
    //    private val broad = MyReceiverDynamic()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_board_cast)
//
//        btn_send_boardcast.setOnClickListener {
////            val intent = Intent(this, MyReceiver::class.java).putExtra("key", "zhangyu")
////            sendBroadcast(intent)
//            val intent = Intent(MyReceiverDynamic.ACTION)
//                .putExtra("key", "zhangyu")
//            sendBroadcast(intent)
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        registerReceiver(broad, IntentFilter(MyReceiverDynamic.ACTION))
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        unregisterReceiver(broad)
//    }
    companion object {
        private const val TAG = "WidgetTestActivity"
    }

    private var binded = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            val myBinder = service as MyBinder
            Log.d(TAG, "onServiceConnected: $name, ${myBinder.getNum()}")
            binded = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "onServiceDisconnected: $name")
            binded = false
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_cast)

        btn_send_boardcast.setOnClickListener {
//            val intent = Intent(this, MyReceiver::class.java).putExtra("key", "zhangyu")
//            sendBroadcast(intent)
            val intent = Intent(MyReceiverDynamic.ACTION)
                .putExtra("key", "zhangyu")
            sendBroadcast(intent)
        }

        btn_send_boardcast.setOnClickListener {
            val intent = Intent(this, MyIntentService::class.java)
            intent.putExtra("task", "播放音乐")
            startService(intent)

            val intent2 = Intent(this, MyIntentService::class.java)
            intent2.putExtra("task", "播放音乐2")
            startService(intent2)
        }

        btn_bind_service.setOnClickListener {
            val intent = Intent(this, TestService::class.java)
            bindService(intent, connection, BIND_AUTO_CREATE)
        }

        btn_unbind_service.setOnClickListener {
            if (binded) {
                unbindService(connection)
            }
        }

        btn_messenger_act.setOnClickListener {
            val intent = Intent(this, MessengerActivity::class.java)
            startActivity(intent)
        }
    }
}
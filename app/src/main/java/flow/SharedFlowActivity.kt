package flow

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.demoapp.databinding.ActivitySharedFlowBinding
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SharedFlowActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "SharedFlowActivity"
    }

    private lateinit var binding: ActivitySharedFlowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedFlowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    @SuppressLint("LogNotTimber")
    private fun test2() {
        val sharedFlow = MutableSharedFlow<Int>(
            replay = 0,
            extraBufferCapacity = 0,
            onBufferOverflow = BufferOverflow.SUSPEND
        )

        lifecycleScope.launch {
            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test2: collect1 received ago shared flow $it")
                }
            }

            launch {
                (1..5).forEach {
                    Log.d(TAG, "test2: emit1  send ago  flow $it")
                    sharedFlow.emit(1)
                    Log.d(TAG, "test2: emit1 send after flow $it")
                }
            }

            delay(100)

            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test2: collect2 received ago shared flow $it")
                }
            }
        }

    }

    fun initView() {
//        val flow = flow<Int> {
//            (1..5).forEach {
//                delay(1000)
//                emit(it)
//            }
//        }
//        binding.btnShareFlow.setOnClickListener {
//            lifecycleScope.launch {
//                flow.collect {
//                    Log.d(TAG, "testFlow 第一个收集器: 我是冷流：$it")
//                }
//            }
//
//            lifecycleScope.launch {
//                flow.collect {
//                    Log.d(TAG, "testFlow 第二个收集器: 我是冷流：$it")
//                }
//            }
//        }
        binding.btnShareFlow2.setOnClickListener{
            test2()
        }
        binding.btnShareFlow3.setOnClickListener{
            test3()
        }
        binding.btnShareFlow4.setOnClickListener {
            test4()
        }
        binding.btnShareFlow5.setOnClickListener {
            test5()
        }
    }

    private fun test5() {
        val sharedFlow = MutableSharedFlow<Int>(
            replay = 0,//相当于粘性数据
            extraBufferCapacity = 2,
            onBufferOverflow = BufferOverflow.SUSPEND //出现背压，采用柱塞的缓存策略
        )

        lifecycleScope.launch {
            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test4: collect1 received ago shared flow $it")
                    delay(100)
                }
            }

            launch {
                (1..5).forEach {
                    Log.d(TAG, "test4: emit1  send ago  flow $it")
                    sharedFlow.emit(it)
                    Log.d(TAG, "test4: emit1 send after flow $it")
                }
            }

            delay(100)

            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test4: collect2 received ago shared flow $it")
                }
            }
        }
    }

    private fun test3() {
        val sharedFlow = MutableSharedFlow<Int>(
            replay = 1,//相当于粘性数据
            extraBufferCapacity = 0,
            onBufferOverflow = BufferOverflow.SUSPEND
        )

        lifecycleScope.launch {
            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test3: collect1 received ago shared flow $it")
                }
            }

            launch {
                (1..5).forEach {
                    Log.d(TAG, "test3: emit1  send ago  flow $it")
                    sharedFlow.emit(it)
                    Log.d(TAG, "test3: emit1 send after flow $it")
                }
            }

            delay(100)

            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test3: collect2 received ago shared flow $it")
                }
            }
        }
    }

    private fun test4() {
        val sharedFlow = MutableSharedFlow<Int>(
            replay = 0,//相当于粘性数据
            extraBufferCapacity = 2,
            onBufferOverflow = BufferOverflow.SUSPEND //出现背压，采用柱塞的缓存策略
        )

        lifecycleScope.launch {
            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test4: collect1 received ago shared flow $it")
                }
            }

            launch {
                (1..5).forEach {
                    Log.d(TAG, "test4: emit1  send ago  flow $it")
                    sharedFlow.emit(it)
                    Log.d(TAG, "test4: emit1 send after flow $it")
                }
            }

            delay(100)

            launch {
                sharedFlow.collect {
                    Log.d(TAG, "test4: collect2 received ago shared flow $it")
                }
            }
        }
    }
}
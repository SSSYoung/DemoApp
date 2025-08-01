package mvvm.player

import android.util.Log
import androidx.lifecycle.*
import mvvm.player.domain.Music

class PlayerPresenter(lifecycleOwner: LifecycleOwner) {

    //class PlayerPresenter private constructor() {
    //改为单例
    private val playerModel by lazy { PlayerModel() }

    private var currMusic: Music? = null


    private val player by lazy {
        MusicPlayer()
    }

    //    private var currentMusic: Music? = null   //数据驱动就不这样写了
    //var currentMusic = DataListenContainer<Music>()//去掉private 让数据可以监听到
    var currentMusic = MutableLiveData<Music>()

    //    private var currentPlayState = PlayState.NONE
    var currentPlayState = DataListenContainer<PlayState>()

    companion object {
        private val TAG = "PlayerPresenter"
    }

    init {
        lifecycleOwner.lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when (event) {
                    Lifecycle.Event.ON_CREATE -> {

                    }
                    Lifecycle.Event.ON_START -> {

                    }
                    Lifecycle.Event.ON_RESUME -> {
                        Log.d(TAG, "onResume: ")
                    }
                    Lifecycle.Event.ON_PAUSE -> {
                        Log.d(TAG, "onPause: ")
                    }
                    Lifecycle.Event.ON_STOP -> {

                    }
                    Lifecycle.Event.ON_DESTROY -> {

                    }
                    else -> {

                    }
                }
            }

        })
    }

    enum class PlayState {
        NONE, PLAYING, PAUSED, LOADING
    }

    private val callbacksList = arrayListOf<IPlayerCallback>() //数据驱动不需要了


    fun registerCallback(callback: IPlayerCallback) {
        if (!callbacksList.contains(callback)) {
            callbacksList.add(callback)
        }

    }

    fun unregisterCallback(callback: IPlayerCallback) {
        callbacksList.remove(callback)
    }

    /**
     * @name PlayerPresenter
     * @describe 根据状态控制音乐播放还是暂停  上一首  下一首
     * @author liangxy
     * @time 2022/6/21 15:51
     *
     */
    var x: Int = 0

    fun doPlayOrPause() {
        //   数据驱动不需要了
        /*       if (currMusic == null) {
              //获取一首歌曲
              currMusic = playerModel.getMusicById("xxx")
          }

          player.play(currMusic)
          dispatchTitleChange("当前播放的歌曲标题...${currMusic?.name}")
               dispatchCoverChange("当前播放的歌曲封面....${currMusic?.cover}")
               if (currentPlayState == PlayState.PLAYING) {
                   //暂停
                   dispatchPauseState()
               } else {
                   //开始播放音乐
                   dispatchPlayingState()
               }
       */
//        if (currentMusic.value == null) {
//            //获取一首歌曲
//            currentMusic.value = playerModel.getMusicById("xxx")
//        }

        currentMusic.postValue(playerModel.getMusicById("xxx"))

        player.play(currMusic)


        if (currentPlayState == null) {
            currentPlayState.value = PlayState.PLAYING
        } else {
            Log.e("当前状态 : %s", currentPlayState.value.toString())
            if (currentPlayState.value != PlayState.PLAYING) {

                currentPlayState.value = PlayState.PLAYING
            } else {
                currentPlayState.value = PlayState.PAUSED
            }
        }

    }


    ////数据驱动不需要了
    /*   fun dispatchPauseState() {
           callbacksList.forEach {
               it.onPlayerPause()
               currentPlayState = PlayState.PAUSED

           }
       }

       fun dispatchPlayingState() {

           callbacksList.forEach {
               it.onPlaying()
               currentPlayState = PlayState.PLAYING

           }
       }*/


    fun playNext() {
        //播放下一首
        //1、拿到下一首歌曲-- >变更UI，包括标题和封面
        //currentMusic.value = playerModel.getMusicById("下一首：火鸟")
        currentMusic.postValue(playerModel.getMusicById("下一首：火鸟"))
//  数据驱动不需要了
        /*      dispatchTitleChange("切换到下一首，标题变了")
              dispatchCoverChange("切换到下一首，封面变了")
              //2、设置给播放器
              // 3、等待播放的回调通知
              currentPlayState = PlayState.PLAYING*/
        currentPlayState.value = PlayState.PLAYING

    }

    /*数据驱动不需要了*/
    fun dispatchCoverChange(cover: String) {
        callbacksList.forEach {
            it.onCoverChange(cover)
        }
    }

    fun dispatchTitleChange(title: String) {
        callbacksList.forEach {
            it.onTitleChange(title)
        }
    }

    fun playPre() {
        //currentMusic.value = playerModel.getMusicById("上一首：白天鹅")
        currentMusic.postValue(playerModel.getMusicById("上一首：白天鹅"))
//     数据驱动不需要了
/*        dispatchTitleChange("切换到上一首，标题变了")
        dispatchCoverChange("切换到上一首，封面变了")
        currentPlayState = PlayState.PLAYING*/
        currentPlayState.value = PlayState.PLAYING
    }

//    override fun onCreate() {
//    }
//
//    override fun onResume() {
//        Log.d(TAG, "onResume: ")
//    }
//
//    override fun onStart() {
//    }
//
//    override fun onPause() {
//        Log.d(TAG, "onPause: ")
//    }
//
//    override fun onStop() {
//    }
//
//    override fun onDestroy() {
//    }
}
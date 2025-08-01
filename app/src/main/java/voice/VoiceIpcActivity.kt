package voice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.desay_svautomotive.voicemanager.SdkManager
import com.desay_svautomotive.voicemanager.VrMediaManager
import com.desay_svautomotive.voicemanager.VrMusicManager
import com.example.demoapp.R

class VoiceIpcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voice_ipc)
        init()
    }

    fun init() {
        SdkManager.getInstance().init(this)
        VrMediaManager.getInstance().setIMediaClient(object : VrMediaManager.IMediaClient {
            override fun openVideo() {
                TODO("Not yet implemented")
            }

            override fun openMusic(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun openRadio() {
                TODO("Not yet implemented")
            }

            override fun openRadioApp() {
                TODO("Not yet implemented")
            }

            override fun exitMedia() {
                TODO("Not yet implemented")
            }

            override fun collect() {
                TODO("Not yet implemented")
            }

            override fun collectCancel() {
                TODO("Not yet implemented")
            }

            override fun collectCheck() {
                TODO("Not yet implemented")
            }

            override fun collectPlay() {
                TODO("Not yet implemented")
            }

            override fun collectPlayRadio() {
                TODO("Not yet implemented")
            }

            override fun collectPlayMusic() {
                TODO("Not yet implemented")
            }

            override fun playTarget(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun resume() {
                TODO("Not yet implemented")
            }

            override fun pause() {
                TODO("Not yet implemented")
            }

            override fun pre() {
                TODO("Not yet implemented")
            }

            override fun next() {
                Log.d(
                    "yangshuang",
                    "next: "
                )
            }

            override fun setPlayMode(p0: Int) {
                TODO("Not yet implemented")
            }

            override fun changePlayMode() {
                TODO("Not yet implemented")
            }

            override fun changeTrackRandom() {
                TODO("Not yet implemented")
            }

            override fun playHistory() {
                TODO("Not yet implemented")
            }

            override fun openLocalMusic() {
                TODO("Not yet implemented")
            }

            override fun openPlaylist() {
                TODO("Not yet implemented")
            }

            override fun openPlaylistType(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun closePlaylist() {
                TODO("Not yet implemented")
            }

            override fun fullScreen(p0: Boolean) {
                TODO("Not yet implemented")
            }

            override fun jumpProgress(p0: Long) {
                TODO("Not yet implemented")
            }

            override fun fastForwardPlay(p0: Long) {
                TODO("Not yet implemented")
            }

            override fun fastRewindPlay(p0: Long) {
                TODO("Not yet implemented")
            }

            override fun ktv(
                p0: String?,
                p1: String?,
                p2: String?,
                p3: String?
            ) {
                TODO("Not yet implemented")
            }

            override fun ktvBar(
                p0: String?,
                p1: String?,
                p2: String?,
                p3: String?
            ) {
                TODO("Not yet implemented")
            }

            override fun mediaCard(p0: String?) {
                TODO("Not yet implemented")
            }

            override fun openSongList() {
                TODO("Not yet implemented")
            }

            override fun closeSongList() {
                TODO("Not yet implemented")
            }

            override fun playSongList() {
                TODO("Not yet implemented")
            }

            override fun addToSongList() {
                TODO("Not yet implemented")
            }

        })
    }
}
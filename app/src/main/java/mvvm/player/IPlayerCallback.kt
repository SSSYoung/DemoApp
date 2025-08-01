package mvvm.player

interface IPlayerCallback {
    fun onTitleChange(title: String)
    fun pnProgressChange ( current: Int)
    fun onPlaying()
    fun onPlayerPause()
    fun onCoverChange(cover: String)
}
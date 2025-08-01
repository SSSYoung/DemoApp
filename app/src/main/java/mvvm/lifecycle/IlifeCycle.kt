package mvvm.lifecycle

/**
 * 自己来实现生命周期变化
 * 问题：如果Fragment呢   又要重新写BaseFragment
 */
interface IlifeCycle {
    fun onCreate()
    fun onResume()
    fun onStart()
    fun onPause()
    fun onStop()
    fun onDestroy()
}
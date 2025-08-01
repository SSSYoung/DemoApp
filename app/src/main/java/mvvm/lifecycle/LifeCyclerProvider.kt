package mvvm.lifecycle

class LifeCyclerProvider {
    private var curLifeState: LifeState? = null

    fun makeLifeState(state: LifeState) {
        curLifeState = state
        when (curLifeState) {
            LifeState.CREATE -> {
                dispatchCreateState()
            }
            LifeState.RESUME -> {

            }
            LifeState.START -> {

            }
            LifeState.PAUSE -> {

            }
            LifeState.STOP -> {

            }
            LifeState.DESTROY -> {

            }
            else -> {

            }
        }
    }

    private fun dispatchCreateState() {
        lifeCycleListeners.forEach {
            it.onCreate()
        }
    }

    private val lifeCycleListeners = arrayListOf<IlifeCycle>()

    fun addLifeCycleListen(listener: IlifeCycle) {
        if (!lifeCycleListeners.contains(listener)) {
            lifeCycleListeners.add(listener)
        }
    }

    fun removeLifeCycleListen(listener: IlifeCycle) {
        lifeCycleListeners.remove(listener)
    }
}
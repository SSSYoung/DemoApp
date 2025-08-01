package kama.patterndesign

/**
 * 小明家有一个万能遥控器，能够支持多个品牌的电视。每个电视可以执行开机、关机和切换频道的操作，
 * 请你使用桥接模式模拟这个操作。
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/6/7
 */
interface Tv {
    fun on()
    fun off()
    fun switchChannel()
}

class HuaWeiTv : Tv {
    override fun on() {
        println("打开华为电视")
    }

    override fun off() {
        println("关闭华为电视")
    }

    override fun switchChannel() {
        println("华为电视换台")
    }
}

class TclTv : Tv {
    override fun on() {
        println("打开Tcl电视")
    }

    override fun off() {
        println("关闭Tcl电视")
    }

    override fun switchChannel() {
        println("华为Tcl换台")
    }
}

abstract class RemoteControl(protected val tv: Tv) {
    abstract fun turnOn()

    abstract fun turnOff()

    abstract fun changeChannel()
}

class UniversalRemoteControl(tv: Tv) : RemoteControl(tv) {
    override fun turnOn() {
        tv.on()
    }

    override fun turnOff() {
        tv.off()
    }

    override fun changeChannel() {
        tv.switchChannel()
    }
}

fun main() {
    val huawei = UniversalRemoteControl(HuaWeiTv())
    val tcl = UniversalRemoteControl(TclTv())

    huawei.apply {
        turnOn()
        turnOff()
        changeChannel()
    }

    tcl.apply {
        turnOn()
        turnOff()
        changeChannel()
    }
}
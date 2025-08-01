package kama.patterndesign

import androidx.compose.animation.core.rememberInfiniteTransition
import java.io.StringReader

/**
 * 建造者模式
 *
 * 小明家新开了一家自行车工厂，用于使用自行车配件（车架 frame 和车轮 tires ）进行组装定制不同的自行车，包括山地车和公路车。
 *
 * 山地车使用的是Aluminum Frame（铝制车架）和 Knobby Tires（可抓地轮胎），公路车使用的是 Carbon Frame （碳车架）和 Slim Tries。
 *
 * 现在它收到了一笔订单，要求定制一批自行车，请你使用【建造者模式】告诉小明这笔订单需要使用那些自行车配置吧。
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/5/15
 */

class Bike(
    private val frame: String,
    private val tires: String
) {
    override fun toString(): String {
        return "Bike with ${frame} and ${tires}"
    }
}

class BikeBuidler {
    private var frame: String? = null
    private var tires: String? = null

    fun setFrame(frame: String): BikeBuidler {
        this.frame = frame
        return this
    }

    fun setTires(tires: String): BikeBuidler {
        this.tires = tires
        return this
    }

    fun build(): Bike {
        if (frame == null || tires == null) {
            throw IllegalStateException("Frame and Tires must be set")
        }
        return Bike(
            frame!!,
            tires!!
        )
    }
}

fun main() {
    val carbonBike = BikeBuidler().setFrame("Carbon Frame").setTires("Slim Tries").build()
    val aluBike = BikeBuidler().setFrame("Aluminum Frame").setTires("Knobby Tires").build()

    println(carbonBike)
    println(aluBike)
}
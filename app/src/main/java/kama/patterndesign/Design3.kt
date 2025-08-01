package kama.patterndesign

import kotlinx.coroutines.newFixedThreadPoolContext

/**
 * 抽象工厂模式
 * 题目描述
 * 小明家新开了两个工厂用来生产家具，一个生产现代风格的沙发和椅子，一个生产古典风格的沙发和椅子，现在工厂收到了一笔订单，请你帮他设计一个系统，描述订单需要生产家具的信息。
 * 输入描述
 * 输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示订单的数量。
 *
 * 接下来的 N 行，每行输入一个字符串，字符串表示家具的类型。家具类型分为 "modern" 和 "classical" 两种。
 *
 * 在工厂方法模式的示例中，我们侧重于一个单一类型的产品（Logger），
 * 并通过不同的工厂（ConsoleLoggerFactory, FileLoggerFactory）创建具体的产品实例。
 * 在抽象工厂模式的示例中，我们创建了多种相关产品（Button, TextBox），
 * 每种产品都有不同风格的具体实现。一个工厂（GUIFactory）负责创建一系列相关产品的所有实例。
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/5/15
 */
interface IFactory {
    fun produceSofa():Sofa
    fun produceChair():Chair
}

abstract class Sofa {
    abstract fun display()
}

abstract class Chair {
    abstract fun display()
}

class ClassicSofa: Sofa() {
    override fun display() {
        println("this is a classic sofa")
    }
}

class ModernSofa: Sofa() {
    override fun display() {
        println("this is a modern sofa")
    }
}

class ClassicChair: Chair() {
    override fun display() {
        println("this is a classic chair")
    }
}

class ModernChair: Chair() {
    override fun display() {
        println("this is a modern chair")
    }
}

class ClassicFactory : IFactory {
    override fun produceSofa(): Sofa {
        return ClassicSofa()
    }

    override fun produceChair(): Chair {
        return ClassicChair()
    }
}

class ModernFactory : IFactory {
    override fun produceSofa(): Sofa {
        return ModernSofa()
    }

    override fun produceChair(): Chair {
        return ModernChair()
    }
}

fun main() {
    val modernFactory = ModernFactory()
    val classicFactory = ClassicFactory()

    modernFactory.produceChair().display()
    modernFactory.produceSofa().display()

    classicFactory.produceChair().display()
    classicFactory.produceSofa().display()
}


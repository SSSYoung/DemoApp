package kama.patterndesign

/**
 * 简单工程模式
 * 题目描述
 * 小明家有两个工厂，一个用于生产圆形积木，一个用于生产方形积木，请你帮他设计一个积木工厂系统，记录积木生产的信息。
 * 输入描述
 * 输入的第一行是一个整数 N（1 ≤ N ≤ 100），表示生产的次数。
 *
 * 接下来的 N 行，每行输入一个字符串和一个整数，字符串表示积木的类型。积木类型分为 "Circle" 和 "Square" 两种。整数表示该积木生产的数量
 *
 * 输出描述
 * 对于每个积木，输出一行字符串表示该积木的信息。
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/5/15
 */
open class Shape() {}

class Circle : Shape() {

}

class Square : Shape() {

}

interface IShapeFactory {
    fun createShape(): Shape
}

class CircleFactory : IShapeFactory {
    override fun createShape(): Shape {
        println("this is a circle")

        return Circle()
    }
}

class SquareFactory: IShapeFactory {
    override fun createShape(): Shape {
        println("this is a square")

        return Square()
    }
}

fun main() {


    val circleFactory = CircleFactory()
    val squareFactory = SquareFactory()

    circleFactory.createShape()
    squareFactory.createShape()
}
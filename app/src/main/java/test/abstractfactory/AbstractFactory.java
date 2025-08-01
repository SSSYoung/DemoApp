package test.abstractfactory;

/**
 * 抽象工厂方法 和工厂方法模式区别：
 * （1）工厂方法只有一个抽象产品类和一个抽象工厂类，但可以派生出多个具体产品类和具体工厂类，每个具体工厂类只能创建一个具体产品类的实例。
 *
 * （2）抽象工厂模式拥有多个抽象产品类（产品族）和一个抽象工厂类，每个抽象产品类可以派生出多个具体产品类；抽象工厂类也可以派生出多个具体工厂类，同时每个具体工厂类可以创建多个具体产品类的实例
 * ————————————————
 * 版权声明：本文为CSDN博主「张维鹏」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/a745233700/article/details/120253639
 */
abstract class AbstractFactory {
   abstract AirCondition manufactureAirCondition();
   abstract Engine manufactureEngine();
}

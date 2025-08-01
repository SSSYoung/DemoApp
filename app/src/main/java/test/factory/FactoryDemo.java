package test.factory;

/**
 * 工厂方法模式
 */
class FactoryDemo {
   public static void main(String[] args) {
      BubbleMilkTeaShop bubbleMilkTeaShop = new BubbleMilkTeaShop();
      bubbleMilkTeaShop.makeMilkTea().drink();
   }
}

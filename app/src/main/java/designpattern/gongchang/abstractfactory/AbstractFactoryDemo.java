package designpattern.gongchang.abstractfactory;

class AbstractFactoryDemo {
   public static void main(String[] args) {
      FactoryA factoryA = new FactoryA();
      FactoryB factoryB = new FactoryB();

      factoryA.ManufactureMould().show();
      factoryA.ManufactureContainer().show();
      
      factoryB.ManufactureContainer().show();
      factoryB.ManufactureMould().show();
   }
}

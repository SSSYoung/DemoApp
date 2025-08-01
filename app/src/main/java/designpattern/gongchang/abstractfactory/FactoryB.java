package designpattern.gongchang.abstractfactory;

class FactoryB extends AbstractFactory{
   @Override
   public Product ManufactureContainer() {
      return new ContainerProductB();
   }

   @Override
   public Product ManufactureMould() {
      return new MouldProductB();
   }
}

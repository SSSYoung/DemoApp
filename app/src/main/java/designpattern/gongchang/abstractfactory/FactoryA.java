package designpattern.gongchang.abstractfactory;

class FactoryA extends AbstractFactory{
   @Override
   public Product ManufactureContainer() {
      return new ContainerProductA();
   }

   @Override
   public Product ManufactureMould() {
      return new MouldProductA();
   }
}

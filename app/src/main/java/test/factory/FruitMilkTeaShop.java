package test.factory;

import test.simplefactory.BubbleMilkTea;
import test.simplefactory.FruitMilkTea;
import test.simplefactory.MilkTea;

class FruitMilkTeaShop extends AbstractMilkTeaFactory {
    @Override
    MilkTea makeMilkTea() {
        return new FruitMilkTea();
    }
}

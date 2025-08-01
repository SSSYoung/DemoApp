package test.factory;

import test.simplefactory.BubbleMilkTea;
import test.simplefactory.MilkTea;
import test.simplefactory.PrimaryOdorMilkTea;

class BubbleMilkTeaShop extends AbstractMilkTeaFactory {
    @Override
    MilkTea makeMilkTea() {
        return new BubbleMilkTea();
    }
}

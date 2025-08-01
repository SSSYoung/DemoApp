package test.factory;

import test.simplefactory.MilkTea;
import test.simplefactory.PrimaryOdorMilkTea;

class PrimaryOdorMilkTeaShop extends AbstractMilkTeaFactory {
    @Override
    MilkTea makeMilkTea() {
        return new PrimaryOdorMilkTea();
    }
}

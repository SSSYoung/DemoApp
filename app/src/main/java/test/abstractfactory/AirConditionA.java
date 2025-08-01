package test.abstractfactory;

class AirConditionA implements AirCondition{
    public AirConditionA() {
        System.out.println("生成空调A");
    }
    @Override
    public void work() {
        System.out.println("空调A工作了");
    }
}

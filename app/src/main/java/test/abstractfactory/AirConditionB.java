
package test.abstractfactory;

class AirConditionB implements AirCondition{
    public AirConditionB() {
        System.out.println("生成空调B");
    }
    @Override
    public void work() {
        System.out.println("空调B工作了");
    }
}

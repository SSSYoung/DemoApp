package test.abstractfactory;

class EngineA implements Engine {
    public EngineA() {
        System.out.println("-------制造发动机A");
    }

    @Override
    public void work() {
        System.out.println("--------发动机A工作");
    }
}

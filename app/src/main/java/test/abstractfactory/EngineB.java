package test.abstractfactory;

class EngineB implements Engine {
    public EngineB() {
        System.out.println("-------制造发动机B");
    }
    @Override
    public void work() {
        System.out.println("发动机B工作");
    }
}

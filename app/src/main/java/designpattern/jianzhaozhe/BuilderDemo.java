package designpattern.jianzhaozhe;

class BuilderDemo {
    public static void main(String[] args) {
        ConcreteBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.Construct("i7-6700", "三星DDR4", "希捷1T");//组装电脑
    }
}

package designpattern.gongchang.simple;

public class SimpleFactory {
    public static Product manufacture(String productName) {
        switch (productName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;
        }
    }
}

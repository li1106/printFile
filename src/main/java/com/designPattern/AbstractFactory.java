package com.designPattern;

/**
 * @ClassName AbstractFactory
 * @Description TODO 抽象工厂模式
 * @Author Administrator
 * @Date 2020/6/3 10:21
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Factory factory = new FactoryA();
        factory.createGift();
        factory.createProduct();
    }
}

interface Product{}
interface Gift {}//也可以是抽象类
class ProductA implements Product {
    public ProductA() {
        System.out.println("ProductA");
    }
}
class ProductB implements Product {
    public ProductB() {
        System.out.println("ProductB");
    }
}
class GiftA implements Gift {
    public GiftA(){
        System.out.println("GiftA");
    }
}
class GiftB implements Gift {
    public GiftB(){
        System.out.println("GiftB");
    }
}

interface Factory {
    public Product createProduct();
    public Gift createGift();

}
class FactoryA implements Factory {
    @Override
    public Product createProduct(){
        return new ProductA();
    }
    @Override
    public Gift createGift(){
        return new GiftA();
    }
}

class FactoryB implements Factory {
    @Override
    public Product createProduct(){
        return new ProductB();
    }
    @Override
    public Gift createGift(){
        return new GiftB();
    }
}

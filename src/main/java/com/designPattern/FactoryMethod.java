//package com.designPattern;
//
///**
// * @ClassName FactoryMethod
// * @Description TODO 工厂方法模式
// * @Author Administrator
// * @Date 2020/6/3 10:07
// */
//public class FactoryMethod {
//    public static void main(String[] args) {
//        Factory factory = new FactoryA();
//        factory.createProduct();
//        factory = new FactoryB();
//        factory.createProduct();
//    }
//}
//interface Product{}
//interface Factory {
//    //声明产生产品类的方法
//    public Product createProduct();
//}
//class ProductA implements Product {
//    public ProductA() {
//        System.out.println("ProductA");
//    }
//}
//class ProductB implements Product {
//    public ProductB() {
//        System.out.println("ProductB");
//    }
//}
//
//class FactoryA implements Factory {
//    //实现工厂类的方法生成产品类A
//    public Product createProduct()
//    {
//        return new ProductA();
//    }
//
//}
//
//class FactoryB implements Factory {
//    //实现工厂类的方法生成产品类B
//    public Product createProduct()
//    {
//        return new ProductB();
//    }
//}

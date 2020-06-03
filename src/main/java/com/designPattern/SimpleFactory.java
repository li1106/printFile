//package com.designPattern;
//
///**
// * @ClassName SimpleFactory
// * @Description TODO 简易工厂模式
// * @Author Administrator
// * @Date 2020/6/3 10:03
// */
//public class SimpleFactory {
//    public static void main(String[] args) {
//        Factory.create("productA");
//        Factory.create("ProductB");
//    }
//}
//
//interface Product {
//    //声明类所需继承的共同接口，也可以是抽象类
//}
//class ProductA implements Product {
//    public ProductA() {
//        System.out.println("ProductA");
//    }
//}
//
//class ProductB implements Product {
//    public ProductB() {
//        System.out.println("ProductB");
//    }
//}
//class Factory {
//    //可以在工厂类中添加任何你所需要的逻辑
//    public static Product create(String str)
//    {
//        //生成ProductA  equalsIgnoreCase:(不考虑大小写)
//        if(str.equalsIgnoreCase("ProductA"))
//        {
//            return new ProductA();
//        }
//        else
//            //生成ProductB
//            if(str.equalsIgnoreCase("ProductB"))
//            {
//                return new ProductB();
//            }
//        return null;
//    }
//}

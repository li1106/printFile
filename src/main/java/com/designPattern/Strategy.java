//package com.designPattern;
//
///**
// * @ClassName Strategy
// * @Description TODO 策略模式
// * @Author Administrator
// * @Date 2020/6/3 10:27
// */
//public class Strategy {
//    public static void main(String[] args) {
//        Car smallCar = new SmallCar("路虎","黑色");
//        Car bussCar = new BussCar("公交车","白色");
//        Person p1 = new Person("小明", 20);
//        p1.driver(smallCar);
//        p1.driver(bussCar);
//    }
//}
//
//interface CarFunction {
//    void run();        //每辆车有不同的行驶方法
//}
//
//class Car implements CarFunction {
//    protected String name;            //车名字
//    protected String color;            //车颜色
//
//    public Car(String name, String color) {
//        this.name = name;
//        this.color = color;
//    }
//
//    @Override
//    public void run() {
//        System.out.println(color +" " + name  +"在行驶。。。");
//    }
//
//}
//class SmallCar extends Car {
//
//    public SmallCar(String name, String color) {
//        super(name, color);
//    }
//    @Override
//    public void run() {
//        System.out.println(color +" " + name  +"在高速的行驶。。。");
//    }
//
//}
//class BussCar extends Car{
//
//    public BussCar(String name, String color) {
//        super(name, color);
//    }
//    @Override
//    public void run() {
//        System.out.println(color +" " + name  +"在缓慢的行驶。。。");
//    }
//}
//class Person {
//    private String name;
//    private Integer age;
//
//    public void driver(Car car){
//        System.out.print(name +"  "+ age+" 岁 "+" 开着");
//        car.run();
//    }
//
//    public Person(String name,Integer age) {
//        this.name=name;
//        this.age=age;
//    }
//}

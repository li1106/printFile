package com.designPattern;

/**
 * @ClassName StaticProxy
 * @Description TODO 静态代理模式
 * @Author Administrator
 * @Date 2020/6/3 10:29
 */
public class StaticProxy {
    public static void main(String[] args) {
        ProxySubject subject = new ProxySubject(new RealSubject());
        subject.visit();
    }
}
interface Subject {
    void visit();
}
class RealSubject implements Subject {

    private String name = "byhieg";
    @Override
    public void visit() {
        System.out.println(name);
    }
}
class ProxySubject implements Subject{
    private Subject subject;
    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void visit() {
        subject.visit();
    }
}

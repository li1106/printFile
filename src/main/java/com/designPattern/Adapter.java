package com.designPattern;

/**
 * @ClassName Adapter
 * @Description TODO 适配器模式
 * @Author Administrator
 * @Date 2020/6/3 10:23
 */
public class Adapter {
    public static void main(String[] args) {
        SmallPort smallPort = new SmallPort() {//手机自带小的接口
            public void useSmallPort() {
                System.out.println("使用的是手机小的接口");
            }
        };
        //需要一个大的接口才可以连上电脑,小口转换为大口
        BigPort bigPort=new SmallToBig(smallPort);
        bigPort.useBigPort();
    }
}

interface BigPort {

    public void useBigPort();//使用的大口
}

interface SmallPort {
    public void useSmallPort();//使用小口
}

class SmallToBig implements BigPort{

    private SmallPort smallPort;//小口

    public SmallToBig(SmallPort smallPort){//获得小口
        this.smallPort=smallPort;
    }
    @Override
    public void useBigPort() {
        this.smallPort.useSmallPort();    //使用小口
    }
}

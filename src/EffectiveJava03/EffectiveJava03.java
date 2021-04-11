package EffectiveJava03;

import java.io.Serializable;

/**
 * @author gemini
 * Created in  2021/4/11 23:27
 * 关于单例设计模式参见：https://www.cnblogs.com/xuwendong/p/9633985.html
 * Effective Java 3:用私有构造器或者枚举类型强化Singleton属性（单例的属性）
 */
class Elvis1 implements Serializable {
    //单例实现方式一： 公有静态成员是个final域
    public static final Elvis1 INSTANCE1 = new Elvis1();

    //构造器设置为private，仅被调用一次用来实例化公有的静态final域Elvis1.INSTANCE1
    private Elvis1() {
    }

    //普通方法
    public void leaveTheBuilding() {
        System.out.println("Elvis1.leaveTheBuilding()" + INSTANCE1);
    }

    //维护并保证Singleton
    private Object readResolve() {
        //返回唯一真实的Elvis实例并且让垃圾收集器留意假冒的Elvis
        return INSTANCE1;
    }
}

class Elvis2 implements Serializable {
    //单例实现方式二： 公有成员是个静态工厂方法
    public static final Elvis2 INSTANCE2 = new Elvis2();

    private Elvis2() {
    }

    //唯一公有成员
    public static Elvis2 getInstance2() {
        return INSTANCE2;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis2.leaveTheBuilding()" + INSTANCE2);
    }

    //维护并保证Singleton
    private Object readResolve() {
        //返回唯一真实的Elvis实例并且让垃圾收集器留意假冒的Elvis
        return INSTANCE2;
    }
}

enum Elvis3 {
    //单例实现方式三： 声明一个包含单个元素的枚举类型-作者最推荐的方法
    //简洁且无偿提供序列化机制
    //关于枚举参见：https://www.cnblogs.com/jingmoxukong/p/6098351.html
    INSTANCE3;

    public void leaveTheBuilding() {
        System.out.println("Elvis3.leaveTheBuilding()" + INSTANCE3);
    }
}

public class EffectiveJava03 {
    public static void main(String[] args) {
        Elvis1 elvis1 = Elvis1.INSTANCE1;
        Elvis2 elvis2 = Elvis2.INSTANCE2;
        Elvis3 elvis3 = Elvis3.INSTANCE3;
        elvis1.leaveTheBuilding();
        elvis2.leaveTheBuilding();
        elvis3.leaveTheBuilding();
    }
}
/*
* outputs:
* Elvis1.leaveTheBuilding()EffectiveJava03.Elvis1@668bc3d5
* Elvis2.leaveTheBuilding()EffectiveJava03.Elvis2@3cda1055
* Elvis3.leaveTheBuilding()INSTANCE3
* */

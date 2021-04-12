package EffectiveJava04;

/**
 * @author gemini
 * Created in  2021/4/12 23:30
 * EffectiveJava04:通过私有构造器强化不可实例化的能力
 * 副作用：使得一个类不可被子类化
 */
//不可实例化的工具类
public class UtilityClass {
    private UtilityClass(){
        throw new AssertionError(); //非必需，但可以避免在类内部调用构造器
    }

    //剩余部分省略
}

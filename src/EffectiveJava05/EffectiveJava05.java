package EffectiveJava05;

import java.util.Objects;

/**
 * @author gemini
 * Created in  2021/4/13 22:27
 * EffectiveJava05:优先考虑依赖注入来引用资源
 */
//把类实现为静态工具类
class SpellChecker{
    private static final int dictionary = 1;
    private SpellChecker(){}
    public static boolean isValid(String word){
        return true;
    }
    public static void suggestions(String typo){}
}
//把类实现为Singleton
class SpellChecker1{
    private static final int dictionary = 1;
    private SpellChecker1(){}
    public static SpellChecker1 INSTANCE = new SpellChecker1();
    public static boolean isValid(String word){
        return true;
    }
    public static void suggestions(String typo){}
}
//依赖注入
public class EffectiveJava05 {
    private final int dictionary;

    public EffectiveJava05(int dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public static boolean isValid(String word){
        return true;
    }
    public static void suggestions(String typo){}

}

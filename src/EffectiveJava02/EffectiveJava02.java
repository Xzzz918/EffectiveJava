package EffectiveJava02;

/**
 * @author gemini
 * Created in  2021/4/9 12:48
 * Effective Java 2：遇到多个构造器参数时考虑使用构建器
 * 建造者模式(Builder Pattern)
 */
class NutritionFacts{
    //营养物质
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder{
        //必需参数
        private final int servingSize;
        private final int servings;
        //可选参数
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;
        //类似于setter的方法
        public Builder(int servingSize, int servings) { this.servingSize = servingSize;this.servings = servings; }
        //以此方法为例 实行参数有效性检查
        public Builder calories(int val){
            if (val <= 0){
                throw new IllegalArgumentException("无效参数： " + val);
            }
            calories = val;
            return this;
        }

        public Builder fat(int val){ fat = val;return this; }

        public Builder sodium(int val){ sodium = val;return this; }

        public Builder carbohydrate(int val){ carbohydrate = val;return this; }

        public NutritionFacts build(){ return new NutritionFacts(this); }

    }

    public NutritionFacts(Builder builder) {

        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "EffectiveJava02.NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}
public class EffectiveJava02 {

    public static void main(String[] args) {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8).calories(-2)
                .sodium(35).carbohydrate(27).fat(55).build();
        System.out.println("cocaCola NutritionFact: " + cocaCola.toString());
    }
}
/*
* 将calories方法参数设为无效的-2后经过有效性检查的输出：
* Exception in thread "main" java.lang.IllegalArgumentException: 无效参数： -2
	at EffectiveJava02.NutritionFacts$Builder.calories(EffectiveJava02.java:32)
	at EffectiveJava02.EffectiveJava02.main(EffectiveJava02.java:73)
* */

package EffectiveJava02.Pizza;

import java.util.Objects;

/**
 * @author gemini
 * Created in  2021/4/11 14:38
 */
public class NyPizza extends Pizza {
    //需要一个尺寸参数
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }
        //协变返回类型：子类方法声明返回父类中声明的返回类型的子类型
        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    @Override
    public String toString() {
        return "NyPizza{" +
                "size=" + size +
                ", toppings=" + toppings +
                '}';
    }

    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(Size.LARGE).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
        System.out.println(nyPizza.toString());
    }
}
/*
 *outputs:
 * NyPizza{size=LARGE, toppings=[ONION, SAUSAGE]}
 *  */

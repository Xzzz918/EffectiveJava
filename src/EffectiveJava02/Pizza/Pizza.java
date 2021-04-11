package EffectiveJava02.Pizza;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author gemini
 * Created in  2021/4/11 0:00
 * Builder pattern for Class hierarchies
 */
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;
    //带有递归类型参数的泛型
    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        //子类必须重写这个方法以便返回“this”
        protected abstract T self();
    }
    //在构造函数中对final变量进行初始化
    public Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "toppings=" + toppings +
                '}';
    }
}

/**
 * @author gemini
 * Created in  2021/4/9 12:48
 * Effective Java 1:用静态工厂方法代替构造器
 */
class StaticFactoryMethod {
    private String type;
    //构造器设为private，这样使得外部创建该类对象时只能通过静态工厂方法
    private StaticFactoryMethod(String type) {
        this.type = type;
    }
    //静态工厂方法
    public static StaticFactoryMethod newInstanceA() {
        return new StaticFactoryMethod("A");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
public class EffectiveJava01 {
    public static void main(String[] args) {
        StaticFactoryMethod staticFactoryMethod = StaticFactoryMethod.newInstanceA();
        System.out.println(staticFactoryMethod.getType());
    }
}


package cn.zou.test_design_mode.strategy;

public class Dog {

    public int weight;
    public int meat;

    public Dog(int weight, int meat) {
        this.weight = weight;
        this.meat = meat;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                ", meat=" + meat +
                '}';
    }
}

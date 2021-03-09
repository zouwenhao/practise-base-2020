package cn.zou.test_design_mode.strategy;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Dog> dogs = Arrays.asList(new Dog(10, 2), new Dog(8,3), new Dog(14, 1));
        MySort mySort = new MySort();
        // 可以将自定义策略封装成单例，防止每次使用时都创建一个对象
        MySort.sort(dogs, (Dog o1, Dog o2) -> {
            if (o1.weight < o2.weight) return -1;
            else if (o1.weight > o2.weight) return 1;
            else return 0;
        });
        for (Dog dog : dogs) {
            System.out.println(dog);
        }
    }
}

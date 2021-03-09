package cn.zou.test_design_mode.strategy;

@FunctionalInterface
public interface Comparator<T> {
    public int compare(T o1, T o2);

    //public int compar();

    default void tesd1() {
        System.out.println(1);
    }

    default void tesd2() {
        System.out.println(1);
    }
}

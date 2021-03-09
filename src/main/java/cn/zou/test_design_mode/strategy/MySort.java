package cn.zou.test_design_mode.strategy;

import java.util.List;

public class MySort<T> {

    public static<T> void sort2(List<T> o, Comparator com) {
        for (int i = 0; i < o.size() - 1; i++) {
            if (com.compare(o.get(i), o.get(i + 1)) > 0)
                // 交换失效
                swap2(o.get(i), o.get(i + 1));
        }
    }

    public static<T> void swap2(T t1, T t2) {
        // 只是修改了两个新创建出来的栈指针的引用，不会影响到引用对象
        T temp = t1;
        t1 = t2;
        t2 = temp;
        // 修改了栈指针引用的实际内容
        ((Dog)t1).meat = 111;
        ((Dog)t2).meat = 111;
    }

    public static<T> void sort(List<T> o, Comparator<? super T> com) {
        for (int i = 0; i < o.size() - 1; i++) {
            if (com.compare(o.get(i), o.get(i + 1)) > 0)
                swap(i, i + 1, o);
        }
    }

    public static<T> void swap(int o1, int o2, List<T> list) {
        T temp = list.get(o1);
        list.set(o1, list.get(o2));
        list.set(o2, temp);
    }
}

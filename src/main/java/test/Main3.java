package test;

import java.beans.Transient;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 implements Serializable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int count = scanner.nextInt();
            Integer[] nums = new Integer[count];
            Arrays.sort(nums, (o1, o2) -> {
                if (o1 > o2) return -1;
                else if (o1 < o2) return 1;
                else return 0;
            });
            System.out.println(countForTarget(nums, 24));

        }
    }

    public static int countForTarget(Integer[] nums, int i) {
        int count = 0;
        counts(Arrays.asList(nums), i);
        return count;
    }

    public static int counts(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int count = 0;
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) < target) {
                count += counts(list.subList(i + 1, list.size()), target - list.get(i));
            } else if (list.get(i) == target) {
                return 1;
            }
        }
        return count;
    }


}

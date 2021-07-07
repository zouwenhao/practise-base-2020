package cn.zou.mianshi.tanma;

import java.util.*;

/**
 * 从n个有序数组中找出最大的10个数
 */
public class FindFirst10InArrays {
    public static void main(String[] args) {
        FindFirst10InArrays findFirst10InArrays = new FindFirst10InArrays();
        Long[][] nums = new Long[][]{
                {1L},
                {2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L},
                {12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L},
                {1L, 3L, 12L, 15L, 26L, 47L, 58L, 69L}};
        Long[] first10InArrays = findFirst10InArrays.findFirst10InArrays(nums);
        System.out.println(Arrays.toString(first10InArrays));
    }

    public Long[] findFirst10InArrays(Long[][] numsArray) {
        TreeSet<Long> first10 = new TreeSet<>();
        for (int i = 0; i < numsArray.length; i++) {
            for (int j = numsArray[i].length - 1; j >= 0; j--) {
                Long num = numsArray[i][j];
                if (first10.size() < 10) {
                    first10.add(num);
                } else {
//                    if (first10.stream().allMatch(r -> r.compareTo(num) < 0 ? true : false)) {
                    if (first10.last() < num) {
                        first10.pollFirst();
                        first10.add(num);
//                    } else if (first10.stream().allMatch(r -> r.compareTo(num) > 0 ? true : false)) {
                    } else if (first10.first() > num) {
                        break;
                    } else {
                        Iterator<Long> iterator = first10.iterator();
                        while (iterator.hasNext()) {
                            Long next = iterator.next();
                            if (next <= num) {
                                first10.pollFirst();
                                first10.add(next);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return first10.toArray(new Long[10]);
    }

}

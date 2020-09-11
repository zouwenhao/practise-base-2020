package cn.zou.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    public static int[] sortIntArray(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int n : nums) {
            numsList.add(n);
        }
        numsList = sortByDC(numsList);
        for (int i = 0; i < numsList.size(); i++) {
            nums[i] = numsList.get(i);
        }
        return nums;
    }

    public static List<Integer> sortByDC(List<Integer> nums) {
        if (nums.size() <= 1) {
            return nums;
        }
        int index = 0;
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            if (num <= nums.get(index)) {
                leftNums.add(num);
            } else if (num > nums.get(index)){
                rightNums.add(num);
            }
        }
        List<Integer> sortedLeft = sortByDC(leftNums);
        List<Integer> sortedRight = sortByDC(rightNums);
        List<Integer> sortedAll = new ArrayList<>();
        sortedAll.addAll(sortedLeft);
        sortedAll.add(nums.get(index));
        sortedAll.addAll(sortedRight);
        return sortedAll;
    }

    public static List<Integer> sortByDC_v1(List<Integer> nums) {
        if (nums.size() <= 1) {
            return nums;
        }
        int index = nums.size() / 2;
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();
        //需要对除了index外的所有元素操作。不管其他值与index值是否相等
        for (int i = 0; i < nums.size(); i++) {
            if (i == index) continue;
            int num = nums.get(i);
            if (num <= nums.get(index)) {
                leftNums.add(num);
            } else if (num > nums.get(index)){
                rightNums.add(num);
            }
        }
        List<Integer> sortedLeft = sortByDC_v1(leftNums);
        List<Integer> sortedRight = sortByDC_v1(rightNums);
        List<Integer> sortedAll = new ArrayList<>();
        sortedAll.addAll(sortedLeft);
        sortedAll.add(nums.get(index));
        sortedAll.addAll(sortedRight);
        return sortedAll;
    }

}

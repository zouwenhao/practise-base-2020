package cn.zou.test_sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, -1, 0, 99, -999, 111};
        maoPaoSort(nums);
        //maoPaoSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void maoPaoSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void maoPaoSort2(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }



}

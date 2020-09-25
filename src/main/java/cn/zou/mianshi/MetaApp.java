package cn.zou.mianshi;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

public class MetaApp {

    public static void main(String[] args) {
        System.out.println(ObjectSizeCalculator.getObjectSize("没人比我更懂java".toCharArray()));

        int[][] nums = new int[][]{
          new int[]{1,2,3,6,10,13},
          new int[]{2,3,7,9,14,17},
          new int[]{4,6,10,14,16,20},
          new int[]{7,8,16,20,22,24},
          new int[]{10,14,20,25,28,35},
          new int[]{11,15,22,26,30,36}
        };
        System.out.println(searchMatrix(nums, 18));
    }

    public static boolean searchMatrix(int[][] nums, int x) {
        if (nums.length == 0 || nums.length != nums[0].length) return false;
        int row = 0, column = nums[0].length - 1;
        int target = nums[row][column];
        while (target != x) {
            if (target > x) {
                column--;
            } else {
                row++;
            }
            if (row > nums.length - 1 || column < 0) return false;
            target = nums[row][column];
        }
        return true;
    }
}

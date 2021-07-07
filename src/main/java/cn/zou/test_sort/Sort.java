package cn.zou.test_sort;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, -1, 0, 99, -999, 111};
        //maoPaoSort(nums);
        //maoPaoSort2(nums);
//        quickSort(nums);
        quickSortV1(nums, 0 , nums.length - 1);
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

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    /**
     * 快排
     * 平均时间复杂度：nlogn；最坏n^2
     * 注意：三处判断包含等于关系
     * @param nums
     * @param start
     * @param end
     */
    public static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int flag = nums[start]; // 设置锚点值
        while (i < j) {
            while (i < j && nums[j] >= flag)
                j--;
            while (i < j && nums[i] <= flag)
                i++;
            // 交换元素
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 交换锚点元素至临界位置 ？？
        nums[start] = nums[j];
        nums[j] = flag;
        // 对左右子集继续排序
        quickSort(nums, start, i - 1);
        quickSort(nums, i + 1, end);
    }

    public static void quickSortV1(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);
            quickSortV1(nums, low, index - 1);
            quickSortV1(nums, index + 1, high);
        }
    }

    public static int getIndex(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

}

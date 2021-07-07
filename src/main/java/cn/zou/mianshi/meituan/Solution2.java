package cn.zou.mianshi.meituan;

import java.util.ArrayList;

public class Solution2 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) return list;
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int index = getIndex(nums, low, high);
            quickSort(nums, low, index - 1);
            quickSort(nums, index + 1, high);
        }
    }

    public int getIndex(int[] nums, int low, int high) {
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

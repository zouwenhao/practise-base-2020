package cn.zou.leetcode.type_numsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T001TwoSum {

    public static void main(String[] args) {
        int[] nums, result;
        T001TwoSum t001TwoSum = new T001TwoSum();
        nums = new int[]{2, 1};
        result = t001TwoSum.twoSum(nums, 4);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
        System.out.println("----------------");
        nums = new int[]{3, 2, 4, 0};
        result = t001TwoSum.twoSum(nums, 6);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
        System.out.println("----------------");
        nums = new int[]{-88, 2, 7, 82, 99};
        result = t001TwoSum.twoSum(nums, -6);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
        System.out.println("----------------");
        nums = new int[]{};
        result = t001TwoSum.twoSum(nums, 4);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
        System.out.println("----------------");
        nums = new int[]{2};
        result = t001TwoSum.twoSum(nums, 4);
        if (result != null) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        }
        System.out.println("----------------");

    }

    /**
     * 从每个数字去找所有其他数字匹配-》从花名册中找对应的数字及索引，如果没有就把自己加进去
     * 特点：返回指定数字的索引，映射关系，Map。
     *
     * 时间复杂度：O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            Integer index = record.get(another);
            if (index == null) {
                record.put(nums[i], i);
            } else {
                return new int[]{index, i};
            }
        }
        return null;
    }

    /**
     * 不是有序数组，双指针不合适。未AC
     * 在排序前，还需要保留元素与索引的对应关系（Hash或数组），都需要增加O(n)
     *
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSumTwoPoint(int[] nums, int target) {
//        Arrays.sort(nums);
//        if (nums == null || nums.length < 2) return null;
//        int small = 0, big = nums.length - 1;
//        while (big > small) {
//            int sum = nums[big] + nums[small];
//            if (sum == target) {
//                return new int[]{small, big}; // 索引位置已经被排序破坏
//            } else if (sum > target){
//                big--;
//            } else {
//                small++;
//            }
//        }
//        return null;
//    }
}

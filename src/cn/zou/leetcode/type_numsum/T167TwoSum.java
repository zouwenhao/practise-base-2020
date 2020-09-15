package cn.zou.leetcode.type_numsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 *     返回的下标值（index1 和 index2）不是从零开始的。
 *     你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T167TwoSum {

    public static void main(String[] args) {
        T167TwoSum t167TwoSum = new T167TwoSum();
        int[] indexs;
        indexs = t167TwoSum.twoSum(new int[]{}, 0);
        if (indexs != null) {
            System.out.println(indexs[0] + " " + indexs[1]);
        }
        System.out.println("---------");
        indexs = t167TwoSum.twoSum(new int[]{-3, 0}, -3);
        if (indexs != null) {
            System.out.println(indexs[0] + " " + indexs[1]);
        }
        System.out.println("---------");
        indexs = t167TwoSum.twoSum(new int[]{-10, -7, -3, -1, 0, 1, 4, 7, 8}, 0);
        if (indexs != null) {
            System.out.println(indexs[0] + " " + indexs[1]);
        }
        System.out.println("---------");
        indexs = t167TwoSum.twoSum(new int[]{-10, -7, -3, -1, 0, 1, 4, 7, 8}, -2);
        if (indexs != null) {
            System.out.println(indexs[0] + " " + indexs[1]);
        }
        System.out.println("---------");
        indexs = t167TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        if (indexs != null) {
            System.out.println(indexs[0] + " " + indexs[1]);
        }
    }

    /**
     *
     * 输入：有序数组 输出：索引 =》 双指针
     * 时间复杂度：O(n)
     * 相比twoSumByMap，执行用时从3ms变为1ms
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return null;
        int small = 0, big = numbers.length - 1;
        while (small < big) {
            int sum = numbers[small] + numbers[big];
            if (sum == target) {
                return new int[]{small + 1, big + 1};
            } else if (sum > target) {
                big--;
            } else {
                small++;
            }
        }
        return null;
    }

    public int[] twoSumByMap(int[] numbers, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = target - numbers[i];
            //if (maps.containsKey(num) && maps.get(num) != i) {
            if (maps.containsKey(num)) {
                return new int[]{maps.get(num) + 1, i + 1};
            }
            maps.put(numbers[i], i);
        }
        return null;
    }
}

package cn.zou.leetcode.type_numsum;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T016ThreeSumClosest {

    public static void main(String[] args) {
        T016ThreeSumClosest t016ThreeSumClosest = new T016ThreeSumClosest();
        int result;
        result = t016ThreeSumClosest.getThreeSumClosest(new int[]{-3, 1, 0, -11, 9, -5 , 3, 7}, 1);
        System.out.println(result);
        result = t016ThreeSumClosest.getThreeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(result);
        result = t016ThreeSumClosest.getThreeSumClosest(new int[]{-1,2,1,-4}, 3);
        System.out.println(result);
        result = t016ThreeSumClosest.getThreeSumClosest(new int[]{0,1,2,3}, 3);
        System.out.println(result);
        result = t016ThreeSumClosest.getThreeSumClosest(new int[]{-1,2,1,-4}, 1);
        System.out.println(result);
    }

    /**
     *
     * 去重？=》不存在=》需要遍历所有结果？=》减少遍历情况
     *
     * 排序数组+双指针
     * 对数组升序排序后，遍历数组中每个元素，每次选取一个其后相邻元素（小指针位置）和数组最后一个元素（大指针位置）作为双指针，进行三数求和并与目标值取差值记录下来。
     * 若差值大于0，将大指针向左移动；若差值小于0，将小指针向右移动；若差值等于0，则表示已找到结果提前退出，不存在比三数之和与目标值相等时更接近的可能。
     *
     * 时间复杂度：O(n^2) <= O((n - 2)*(1/2*n | (n - 1)))
     *
     * @param nums
     * @param target
     * @return
     */
    public int getThreeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = 0;
        // *:Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int length = nums[i] + nums[left] + nums[right] - target;
                if (Math.abs(length) < Math.abs(closest)) {
                    closest = length;
                    result = nums[i] + nums[left] + nums[right];
                }
                if (length == 0) {
                    return result;
                } else if (length > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}

package cn.zou.leetcode.type_numsum;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class T53MaxSubArray {

    public static void main(String[] args) {
        T53MaxSubArray t53MaxSubArray = new T53MaxSubArray();
        System.out.println(t53MaxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxSum = Integer.MIN_VALUE;
        int preMax = 0;
        for (int i = 0; i < nums.length; i++) {
            preMax = Integer.max(preMax + nums[i], nums[i]);
            maxSum = preMax >= maxSum ? preMax : maxSum;
        }
        return maxSum;
    }
}

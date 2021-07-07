package cn.zou.mianshi.meituan;

/**
 * 连续无序数组中连续子数组的最大值
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getMaxSumInSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution1.getMaxSumInSubArray(new int[]{-2}));
        System.out.println(solution1.getMaxSumInSubArray(new int[]{1}));
        System.out.println(solution1.getMaxSumInSubArray(new int[]{-10000}));
        System.out.println(Integer.MAX_VALUE);
    }

    public Long getMaxSumInSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return  null;
        }
        Long maxSum = Long.MIN_VALUE;
        Long lastMax = 0L;
        for (int i = 0; i < nums.length; i++) {
            lastMax = Long.max(lastMax + nums[i], nums[i]);
            maxSum = lastMax >= maxSum ? lastMax : maxSum;
        }
        return maxSum;
    }
}

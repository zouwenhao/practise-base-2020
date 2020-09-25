package cn.zou.leetcode.type_numsum;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 *
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 *
 *
 * 示例2:
 *
 * 输入: 3
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T633JudgeSquareSum {

    public static void main(String[] args) {
        T633JudgeSquareSum t633JudgeSquareSum = new T633JudgeSquareSum();
        System.out.println(t633JudgeSquareSum.judgeSquareSum(0));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(1));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(2));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(3));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(4));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(5));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(9));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(14));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(21));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(25));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(50));
        System.out.println(t633JudgeSquareSum.judgeSquareSum(54));
    }

    /**
     *
     * 隐藏题意：
     * 1. 两个整数：可以是两个相等的整数；数据源可以是负数，但平方后的数和对称的正整数效果一样，所以用正整数区间内判断即可
     *
     * 思路：双指针对取0和n分别作为小数和大数，判断平方的和：大于时大数-1；小于时小数+1；等于时返回true
     * 优化：剪枝，符合结果的大数不会大于n的开方，所以可以把大数从n变成n的开方向下取整
     *
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * 其他：用两数相乘替换Math.pow()，执行用时从7～10ms变到3ms =》 尽量减少api的使用
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int small = 0, big = (int)Math.floor(Math.sqrt(c));
        while (big >= small) {
            //int sum = (int)(Math.pow(small, 2) + Math.pow(big, 2));
            int sum = small * small + big * big;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                big --;
            } else {
                small++;
            }
        }
        return false;
    }
}

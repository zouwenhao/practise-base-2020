package cn.zou.leetcode.type_numsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 *
 * 例如:
 *
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T454FourSumCount {

    public static void main(String[] args) {
        T454FourSumCount t454FourSumCount = new T454FourSumCount();
        int[] A, B, C, D;
        A = new int[]{-1, 1};
        B = new int[]{0, 2};
        C = new int[]{1, -2};
        D = new int[]{2, -1};
        System.out.println(t454FourSumCount.fourSumCount(A, B, C, D));
        A = new int[]{0, 0};
        B = new int[]{0, 0};
        C = new int[]{0, 0};
        D = new int[]{0, 0};
        System.out.println(t454FourSumCount.fourSumCount(A, B, C, D));
        A = new int[]{1, 2};
        B = new int[]{-2, -1};
        C = new int[]{-1, 2};
        D = new int[]{0, 2};
        System.out.println(t454FourSumCount.fourSumCount(A, B, C, D));
    }

    /**
     *
     * 注：只需要记总数，不需要返回具体组合数据
     *
     * 将四数差分成两组，第一组算前两位数的合值与对应总数的映射，后两组算目标值=0-（后两位数合值），从映射表中取值相乘再求和
     * 时间复杂度：O(n^2) <= O(n*n*1 + n^n*1)
     *
     * 使用Hash保存数值和与次数的映射
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer, Integer> sumCountAB = new HashMap<>();
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                int sumAB = A[a] + B[b];
                if (sumCountAB.containsKey(sumAB)) {
                    sumCountAB.put(sumAB, sumCountAB.get(sumAB) + 1);
                } else {
                    sumCountAB.put(sumAB, 1);
                }
           }
        }
        for (int c = 0; c < C.length; c++) {
            for (int d = 0; d < D.length; d++) {
                int target = -(C[c] + D[d]);
                if (sumCountAB.containsKey(target)) {
                    count += sumCountAB.get(target);
                }
            }
        }
        return count;
    }

}

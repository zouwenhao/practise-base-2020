package cn.zou.leetcode.type_find;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T215FindKthLargest {

    public static void main(String[] args) {
        T215FindKthLargest kthLargest = new T215FindKthLargest();
        int[] nums1 = new int[]{3,2,1,5,6,4};
        System.out.println(kthLargest.findKthLargest(nums1, 2));
        int[] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(kthLargest.findKthLargest(nums2, 4));
    }

    /**
     * 基于优先队列的api
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int nums[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}

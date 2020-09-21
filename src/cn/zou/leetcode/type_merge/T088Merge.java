package cn.zou.leetcode.type_merge;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T088Merge {

    public static void main(String[] args) {
        T088Merge t088Merge = new T088Merge();
        int[] nums1 = new int[]{1,2,3,6,7,8,9,9,14,17,18,21,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] nums2 = new int[]{2,5,6,8,9,10,11,15,17,18,19,22,24,27,29,30};
        t088Merge.merge_v2(nums1, 12, nums2, 16);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

    /**
     * 合并两个有序数组A、B到数组A
     * 双指针：（AC）
     * 1.设置一个新数组C
     * 2.分别为数组A、B、C设置索引，初始化为0。
     * 3.当两索引都小于对应数组数字总数时，挑选数字给新数组：
     *  1).数组A索引处的数字小于数组B索引处的数字时，将数组A索引处的数字赋值给数组C索引处，移动索引A；反之处理数组B的。移动索引C
     * 4.判断索引A和B，将其中还在对应总数的那个数组的剩余数字赋值给数组C
     * 5.将数组C拷贝给A
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0, index3 = 0;
        int[] nums3 = new int[nums1.length];
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                nums3[index3++] = nums1[index1++];
            } else {
                nums3[index3++] = nums2[index2++];
            }
        }
        if (index1 == m) {
            for (int i = index2; i < n; i++){
                nums3[index3++] = nums2[i];
            }
        } else {
            for (int i = index1; i < m; i++){
                nums3[index3++] = nums1[i];
            }
        }
        for (int i = 0; i < nums3.length; i++){
            nums1[i] = nums3[i];
        }
    }

    /**
     * 对merge的写法优化（AC）
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge_v2(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0, index3 = 0;
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        while (index3 < m && index2 < n) {
            nums1[index1++] = nums2[index2] < nums3[index3] ? nums2[index2++] : nums3[index3++];
        }
        if (index3 == m) {
            System.arraycopy(nums2, index2, nums1, index1, n - index2);
        } else {
            System.arraycopy(nums3, index3, nums1, index1, m - index3);
        }
    }
}

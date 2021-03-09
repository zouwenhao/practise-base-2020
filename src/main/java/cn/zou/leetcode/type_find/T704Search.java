package cn.zou.leetcode.type_find;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T704Search {

    public static void main(String[] args) {
        T704Search t704Search = new T704Search();
        System.out.println(t704Search.search(new int[]{}, 0));
        System.out.println(t704Search.search(new int[]{0}, 0));
        System.out.println(t704Search.search(new int[]{0}, 1));
        System.out.println(t704Search.search(new int[]{1,2}, 1));
        System.out.println(t704Search.search(new int[]{1,2}, 2));
        System.out.println(t704Search.search(new int[]{1,2,3}, 2));
        System.out.println(t704Search.search(new int[]{1,2,3,4}, 4));
        System.out.println(t704Search.search(new int[]{1,2,3,4,5}, 0));
        System.out.println(t704Search.search(new int[]{0,1,3,4,5,6}, 2));
        System.out.println(t704Search.search(new int[]{1,2,3}, 1));
    }
    
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //return searchByRec(nums, left, right, target);
        return searchByRecRetest(nums, left, right, target);
        //return searchByHalf(nums, target);
        //return searchByHalfRetest(nums, target);
    }

    /**
     * 二分查找（模拟，AC）：
     * 每次取出当前查找范围中间的值：
     * 1). 若与目标值相等，则返回
     * 2). 若比目标值大，则从其左边范围查找（移动右边界至此中间值的左侧）
     * 3). 若比目标值小，则从其右边范围查找（移动左边界至此中间值的右侧）
     * 当右边界大于等于左边界时，才会一直寻找，否则说明左右边界最后落在同一个数字的情况时，仍未找到目标值，
     * 才会出现左边界（右边界）被移动到了右边界（左边界）的右边（左边）
     *
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int searchByHalf(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int middle = right / 2;
        while (left <= right) {
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return -1;
    }

    public int searchByHalfRetest(int[] nums, int target) {
        if (nums == null) return -1;
        int left = 0, right = nums.length - 1;
        int middle = right / 2;
        while (left <= right) {
            if (nums[middle] == target) return middle;
            else if (nums[middle] > target) right = middle - 1;
            else left = middle + 1;
            middle = (left + right) / 2;
        }
        return -1;
    }

    /**
     *
     * 二分查找（递归，AC）：
     * 每次取出当前查找范围中间的值：
     * 1). 若与目标值相等，则返回当前中值
     * 2). 若比目标值大，移动右边界至此中间值的左侧
     * 3). 若比目标值小，移动左边界至此中间值的右侧
     * 从新的查找范围中返回结果
     * 当左边界大于右边界时，退出
     * @param nums
     * @param left
     * @param right
     * @param target
     * @return
     */
    public int searchByRec(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            right = middle - 1;
        } else {
            left = middle + 1;
        }
        return searchByRec(nums, left, right, target);
    }

    public int searchByRecRetest(int[] nums, int left, int right, int target) {
        if (left > right) return -1;
        int middle = (left + right) / 2;
        if (nums[middle] == target) return middle;
        else if (nums[middle] > target) return searchByRecRetest(nums, left, middle - 1, target);
        else return searchByRecRetest(nums, middle + 1, right, target);
    }

    public int searchByHalf_error(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        int index = (left + right) / 2;
        int last;
        while (nums[index] != target) {
            last = index;
            if (nums[index] > target) {
                right = index;
            } else {
                left = index;
            }
            index = (int)Math.round((left + right) / 2.0);
            if (index == last) return -1;
        }
        return index;
    }

}

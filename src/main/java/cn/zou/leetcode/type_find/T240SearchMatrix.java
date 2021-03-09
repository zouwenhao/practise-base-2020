package cn.zou.leetcode.type_find;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 *     每行的元素从左到右升序排列。
 *     每列的元素从上到下升序排列。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T240SearchMatrix {

    public static void main(String[] args) {
        T240SearchMatrix find = new T240SearchMatrix();
        int[][] nums1 = new int[][]{{1,3,4,6},{2,7,8,10}};
        System.out.println(find.searchMatrixRetest(nums1,9));
        System.out.println(find.searchMatrixRetest(null,9));
        System.out.println(find.searchMatrixRetest(new int[][]{{}},9));
        System.out.println(find.searchMatrixRetest(new int[][]{{1}},1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 注意无效数组的范围
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public boolean searchMatrixRetest(int[][] nums, int target) {
        if (nums == null) return false;
        int row = 0, column = nums[0].length - 1;
        while (row != nums.length && column != -1) {
            if (nums[row][column] == target) return true;
            else if (nums[row][column] > target) column--;
            else row++;
        }
        return false;
    }
}

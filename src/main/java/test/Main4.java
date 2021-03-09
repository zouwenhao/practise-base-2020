package test;

import java.util.Arrays;

public class Main4 {

    public static void main(String[] args) {
        Main4 math4 = new Main4();
        int[] nums = new int[]{2,3,4,5,6,10};
        System.out.println(math4.getMax(nums));
    }

    /**
     * 1 2 2
     * 1 3 3
     * 2 4 5 6 7 8 20
     * 2 4 5 6 10
     * @param nums
     * @return
     */
    public int getMax(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (isThreeAngel(nums[i-2], nums[i-1], nums[i])) return nums[i-2] + nums[i-1] + nums[i];
        }
        return 0;
    }

    public boolean isThreeAngel(int x, int y, int z) {
        if (x + y > z) return true;
        return false;
    }
}

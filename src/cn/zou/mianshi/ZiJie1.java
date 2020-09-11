package cn.zou.mianshi;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ZiJie1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入");
        String str;
        str = scanner.nextLine();
        String[] s = str.split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        List<int[]> numbers = getThreeNumbersToZero(nums);
        for (int[] num:numbers) {
            System.out.print(num[0]);
            System.out.print(num[1]);
            System.out.print(num[2]);
            System.out.println();
        }

    }

    public static List<int[]> getThreeNumbersToZero(int[] nums) {
        List<int[]> numbersList = new ArrayList<int[]>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int thirdNumber = 0 - nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (thirdNumber == nums[k]) {
                        int[] numbers = new int[3];
                        numbers[0] = nums[i];
                        numbers[1] = nums[j];
                        numbers[2] = nums[k];
                        numbersList.add(numbers);
                    }
                }
            }
        }
        return numbersList;
    }


}

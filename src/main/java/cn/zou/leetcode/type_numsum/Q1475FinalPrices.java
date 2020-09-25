package cn.zou.leetcode.type_numsum;

import java.util.Arrays;

/**
 * Given the array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i], otherwise, you will not receive any discount at all.
 *
 * Return an array where the ith element is the final price you will pay for the ith item of the shop considering the special discount.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 *
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 * Explanation: In this case, for all items, you will not receive any discount at all.
 *
 * Example 3:
 *
 * Input: prices = [10,1,1,6]
 * Output: [9,0,1,6]
 *
 *
 *
 * Constraints:
 *
 *     1 <= prices.length <= 500
 *     1 <= prices[i] <= 10^3
 */
public class Q1475FinalPrices {

    public static void main(String[] args) {
        int[] prices;
        Q1475FinalPrices q1475FinalPrices = new Q1475FinalPrices();
        prices = new int[]{1,2,3,4,5};
        prices = q1475FinalPrices.finalPrices(prices);
        System.out.println(Arrays.toString(prices));

        prices = new int[]{5,4,3,2,1};
        prices = q1475FinalPrices.finalPrices(prices);
        System.out.println(Arrays.toString(prices));

        prices = new int[]{};
        prices = q1475FinalPrices.finalPrices(prices);
        System.out.println(Arrays.toString(prices));

        prices = new int[]{5,2,6,2,7,9,2,45};
        prices = q1475FinalPrices.finalPrices(prices);
        System.out.println(Arrays.toString(prices));
    }

    /**
     * 模拟：对数组中的每个数n，依次找其后面小于它的数m，找到时将其更新为n-m，退出当前循环
     *
     * 最好情况：O(n)，递减数组 [5,4,3,2,1]
     * 最坏情况：O(n^2)，递增数组 [1,2,3,4,5]
     * 空间复杂度：O(1)
     * @param prices
     * @return
     */
    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    prices[i] -= prices[j];
                    break;
                }
            }
        }
        return prices;
    }

}

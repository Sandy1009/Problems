/*
https://leetcode.com/problems/get-equal-substrings-within-budget/description/?envType=daily-question&envId=2024-05-28
 */

public class EqualSubStringsWithinBudget {

    public static void main(String[] ar) {
        /*String s = "krrgw";
        String t = "zjxss";
        int maxCost = 19;*/

        /*String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;*/

        /*String s = "abcd";
        String t = "abcd";
        int maxCost = 0;*/

        String s = "abcd";
        String t = "cdef";
        int maxCost = 1;

        /*String s = "abcd";
        String t = "acde";
        int maxCost = 0;*/

        System.out.println(equalSubstring(s, t, maxCost));
    }

    public static int equalSubstring(String s, String t, int maxCost) {

       // if (maxCost == 0) return 1;

        int[] diff = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int v1 = s.charAt(i) - 'a';
            int v2 = t.charAt(i) - 'a';

            diff[i] = Math.abs(v1 - v2);
        }

        int sum = diff[0];
        int len = 1;
        int left = 0;
        int res = (sum <= maxCost) ? 1 : 0;

        for(int i=1; i<s.length(); i++) {
            sum += diff[i];
            len++;

            while(sum > maxCost) {
                sum -= diff[left];
                left++;
                len--;
            }

            res = Math.max(res, len);
        }

        return res;
    }
}

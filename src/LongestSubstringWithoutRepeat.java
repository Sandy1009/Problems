/*
Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters.
The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
Your task is to return an integer representing the "GOOD"ness of string A.
Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.

 A = "abcabcbb"
output = 3
explanation: Substring "abc" is the longest substring without repeating characters in string A.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] ar) {
        String A = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

        int res = lengthOfLongestSubstring(A);
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String A) {

        String res = "";
        Set<Character> set = new HashSet<>();
        int max = Integer.MIN_VALUE;

        for(char ch : A.toCharArray()) {
            if(!set.contains(ch)) {
                res += String.valueOf(ch);
                set.add(ch);
            } else {
                String temp = String.valueOf(ch);
                res = res.substring(res.indexOf(temp)+1);
                res += temp;
            }
            max = Math.max(max, res.length());
        }
        return max;

    }

}

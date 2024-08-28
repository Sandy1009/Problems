/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 105.

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

import java.util.Stack;

public class Leetcode394 {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
      //String s = "3[a2[c]]";
      //  String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    private static String decodeString(String s) {

        Stack<Integer> num = new Stack();
        Stack<String> str = new Stack();
        String temp = "";
        int index = 0;

        while(index < s.length()) {
            char ch = s.charAt(index);
            if(Character.isDigit(ch)) {
                StringBuilder tempNum = new StringBuilder();

                while(Character.isDigit(s.charAt(index))) {
                    tempNum.append(s.charAt(index));
                    index++;
                }
                num.push(Integer.parseInt(tempNum.reverse().toString()));
            } else if(ch == '[') {
                str.push(temp);
                temp = "";
                index++;
            } else if(Character.isLetter(ch)) {
                temp += ch;
                index++;
            } else if(ch == ']') {
                StringBuilder tempStr = new StringBuilder(str.pop());
                int count = num.pop();
                while(count-- > 0) {
                    tempStr.append(temp);
                }
                temp = tempStr.toString();
                index++;
            }
        }

        return temp;

    }
}

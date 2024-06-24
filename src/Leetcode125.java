/*
https://leetcode.com/problems/valid-palindrome/?envType=study-plan-v2&envId=top-interview-150
 */

public class Leetcode125 {

    public static void main(String ar[]) {
        String s = "0P";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {

        int n = s.length();
        int start = 0;
        int end = n-1;

        while(start < end) {
            if(!Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))) start++;
            else if(!Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))) end--;
            else {
                char ch1 = Character.toLowerCase(s.charAt(start));
                char ch2 = Character.toLowerCase(s.charAt(end));

                if(ch1 != ch2) return false;
                start++;
                end--;
            }
        }

        return true;

    }

}

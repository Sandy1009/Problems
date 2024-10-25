package Leetcode75;

import java.sql.SQLOutput;

public class Leetcode443 {

    public static void main(String[] args) {
        //char[] chars = {'a','a','b','b','c','c','c'};

        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        int j = compress(chars);

        for(int i = 0; i<j; i++) {
            System.out.print(chars[i]+"  ");
        }
    }

    public static int compress(char[] chars) {

        int res = 0;

        for(int i = 0; i<chars.length; ){
            char c = chars[i];
            int count = 0;

            while(i < chars.length && chars[i]==c) {
                count++;
                i++;
            }

            chars[res] = c;
            res++;

            if(count > 1) {
                for(char ch : String.valueOf(count).toCharArray()) {
                    chars[res] = ch;
                    res++;
                }
            }
        }

        return res;
    }

}


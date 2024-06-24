/*
Given a string n, your task is to find whether it contains an additive sequence or not.
A string n contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers.
You are required to complete the function which returns true if the string is a valid sequence else returns false.
Note: A valid string should contain at least three digit to make one additive sequence.

Input:
n = "1235813"
Output:
1
Explanation: The given string can be splited into a series of numbers
where each number is the sum of the previous two numbers:
1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8, and 5 + 8 = 13. Hence, the output would be 1 (true).
 */
public class AdditiveSequence {

    public static void main(String[] ar) {

        String n = "1235813";
        int len = n.length();

      //  if(len < 3) return false;

        for(int i=2; i<len; i++) {

            int first = n.charAt(i-2) - '0';
            int second = n.charAt(i-1) - '0';

            int sum = first + second;
            int tempSum = sum;

            int count = i;

            while(count<len && sum > 0) {
                //int rem = sum%10;
                sum /= 10;
                count++;
            }

            String str = n.substring(i, count);
            int third = Integer.parseInt(str);

            if(tempSum != third) {
                System.out.println("false");
                System.exit(0);
            }

            i = count-1;

        }

        System.out.println("true");

    }

    /*
    int num1 = 0;
        int size =n.length();
        for(int i=0;i < (size/2);i++){
            num1 = num1*10 + (n.charAt(i)-'0');
            int num2 = 0;
        for(int j=i+1;j<size-1;j++){
            num2 = num2*10 + (n.charAt(j)-'0');
            int first = num1,second = num2,num3=0;
            int k=j+1;
            while(k <size){
                num3 = num3*10 + (n.charAt(k)-'0');
                if(num3==first+second){
                    first = second;
                    second = num3;
                    num3 =0;
                }
                k++;
            }
            if(k==size && num3==0){
                return true;
            }
        }

    }
    return false;
     */

}

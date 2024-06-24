/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
 */
public class FirstMissingPositiveInteger {

    public static void main(String[] ar) {

       // int[] nums = {1,1};
        int[] nums = {3,4,-1,1};
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(nums[i] < 1) nums[i] = n+3;
        }

        for(int i=0; i<n; i++) {
            int temp = Math.abs(nums[i]);
            if(temp <= n) {
                int index = temp - 1;
                nums[index] = (-1) * Math.abs(nums[index]);
            }
        }

        int res = n+1;
        for(int i=0; i<n; i++) {
            if(nums[i] > 0) {
                res = i+1;
                break;
            }
        }

        System.out.println(res);

    }

}

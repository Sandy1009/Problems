/*
You are given an integer array nums and a positive integer k.
Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
A subarray is a contiguous sequence of elements within an array.

Input: nums = [1,3,2,3,3], k = 2
Output: 6
Explanation: The subarrays that contain the element 3 at least 2 times are: [1,3,2,3], [1,3,2,3,3], [3,2,3], [3,2,3,3], [2,3,3] and [3,3].
 */

public class Leetcode2962 {

    public static void main(String[] ar) {

        int[] nums = {1,3,2,3,3};
        int k = 2;

        int n = nums.length;
        int count = 0;

        int max = Integer.MIN_VALUE;
        int maxCount = 0;

        for(int i=0; i<n; i++) {
            max = Math.max(max, nums[i]);
        }

        for(int i=0; i<n; i++) {
            if(nums[i] == max) maxCount++;
        }

     //   if(maxCount < k) return 0;

        int left = 0;
        int right = 0;
        long res = 0;

        while(right < n) {

            if(nums[right] == max) {
                count++;
            }

            while(count == k) {
                if(nums[left] == max) count--;
                left++;
                res += n-right;
            }
            right++;

        }
        System.out.println(res);
    }

}

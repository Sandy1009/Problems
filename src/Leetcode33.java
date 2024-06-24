/*
https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */

public class Leetcode33 {

    public static void main(String[] ar) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {

        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r) {
            int mid = l + (r-l)/2;

            if(nums[mid] == target) return mid;

            /*if(target < nums[0]) {
                if(nums[mid] < nums[0]) {
                    if(nums[mid] < target) l = mid+1;
                    else r = mid-1;
                } else l = mid+1;
            } else {
                if(nums[mid] < nums[0]) {
                    if(nums[mid] < target) r = mid-1;
                    else l = mid+1;
                } else r = mid-1;
            }*/

            if(nums[0] <= nums[mid]) {
                if(nums[0] <= target && target < nums[mid]) r = mid-1;
                else l = mid+1;
            } else {
                if(target > nums[mid] && target <= nums[r]) l = mid+1;
                else r = mid-1;
            }

        }

        return -1;

    }
}

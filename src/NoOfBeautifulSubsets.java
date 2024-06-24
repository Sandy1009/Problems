/*
https://leetcode.com/problems/the-number-of-beautiful-subsets/description/?envType=daily-question&envId=2024-05-23
 */

import java.util.ArrayList;
import java.util.List;

public class NoOfBeautifulSubsets {

    public static void main(String[] ar) {
        /*int[] nums = {2,4,6};
        int k = 2;*/

        int[] nums = {4,2,5,9,10,3};
        int  k = 1;

        System.out.println(beautifulSubsets(nums, k));
    }

    private static int beautifulSubsets(int[] nums, int k) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        findSubsets(nums, 0, list, res);
        int count = 0;

        for(List<Integer> ll : res) {
            if(ll.size() == 1) count++;
            else {
                boolean isBeautiful = true;
                for (int i = 0; i < ll.size(); i++) {
                    for (int j = i + 1; j < ll.size(); j++) {
                        if (Math.abs(ll.get(i) - ll.get(j)) == k) {
                            isBeautiful = false;
                            break;
                        }
                    }
                    if (!isBeautiful) {
                        break;
                    }
                }
                if (isBeautiful) {
                    count++;
                }
            }
        }

        return count;

    }

    private static void findSubsets(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if(!list.isEmpty()) {
            res.add(new ArrayList<>(list));
        }

        for(int i=index; i<nums.length; i++) {
            list.add(nums[i]);
            findSubsets(nums, i+1, list, res);
            list.remove(list.size()-1);
        }
    }
}

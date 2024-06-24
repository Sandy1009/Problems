import java.util.*;

public class LeetCode_506_Ranks {

    public static void main(String[] ar) {
        int[] score = {5,4,3,2,1};
        String[] res = findRelativeRanks(score);

        for(String s : res) System.out.print(s+"    ");
    }

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : score) q.add(i);

        String[] res = new String[n];

        Map<Integer, String> map = new HashMap<>();
        int index = 0;

        while(!q.isEmpty()) {
            int temp = q.poll();
            //  System.out.print(temp+"   ");
            if(index == 0) map.put(temp, "Gold Medal");
            else if(index == 1) map.put(temp, "Silver Medal");
            else if(index == 2) map.put(temp, "Bronze Medal");
            else if(index == 3) map.put(temp, "4");
            else map.put(temp, "5");
            index++;
        }

        for(int i=0; i<n; i++) {
            res[i] = map.get(score[i]);
        }

        return res;

    }
}

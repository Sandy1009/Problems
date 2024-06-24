/*
https://www.geeksforgeeks.org/problems/k-closest-elements3619/1
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KthClosestElements {

    public static void main(String[] ar) {
        int n = 13;
        int arr[] = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        int k = 4, x = 35;

        int[] res = new int[k];

        printKClosest(arr, n, k, x, res, 0);

        for(int i : res) {
            System.out.print(i+"    ");
        }

    }

    private static int[] printKClosest(int[] arr, int n, int k, int x, int[] res, int index) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for(int i=0; i<n; i++) {
            int temp = Math.abs(x-arr[i]);
            if(map.containsKey(temp)) {
               map.get(temp).add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(temp, list);
            }
        }

        for(Map.Entry entry : map.entrySet()) {
            int key = (int) entry.getKey();

            if(key != 0) {
                List<Integer> list = (ArrayList) entry.getValue();
                for(int i : list) {
                    if(k-- > 0) {
                        res[index++] = arr[i];
                    } else break;
                }
            }

            if(k == 0) break;
        }

        return res;
    }
}

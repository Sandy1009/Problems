/*
https://leetcode.com/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150
 */

public class Leetcode74 {

    public static void main(String[] ar) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = m-1;

        while(start < n && end >= 0) {
            if(matrix[start][end] == target) return true;
            else if(matrix[start][end] > target) end--;
            else start++;
        }

        return false;

    }

}

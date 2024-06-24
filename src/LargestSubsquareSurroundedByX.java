/*
Given a square matrix a of size n x n, where each cell can be either 'X' or 'O', you need to find the size of the largest square subgrid that is completely surrounded by 'X'. More formally you need to find the largest square within the grid where all its border cells are 'X'.
Input:
n = 2
a = [[X,X],
     [X,X]]
Output:
2
Explanation:
The largest square submatrix surrounded by X is the whole input matrix.

Input:
n = 4
a = [[X,X,X,O],
     [X,O,X,X],
     [X,X,X,O],
     [X,O,X,X]]
Output:
3
Explanation:
Here,the input represents following matrix of size 4 x 4
X X X O
X O X X
X X X
 */
public class LargestSubsquareSurroundedByX {

    public static void main(String[] ar) {

       int n = 2;
        char[][] a = {{'X', 'X'}, {'X', 'X'}};

      //  int n = 4;
      //  char[][] a = {{'X', 'X', 'X', 'O'}, {'X', 'O', 'X', 'X'}, {'X', 'X', 'X', 'O'}, {'X', 'O', 'X', 'X'}};

        int row[][] = new int[n][n];
        int col[][] = new int[n][n];
        for(int i=0;i<n;i++){
            int r = 0,c = 0;
            for(int j=0;j<n;j++){
                r = a[i][j]=='X'?++r:0;
                c = a[j][i]=='X'?++c:0;
                row[i][j] = r;
                col[j][i] = c;
            }
        }
        int res = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int s = Math.min(row[i][j],col[i][j]);
                while(s>res){
                    if(row[i-s+1][j]>=s && col[i][j-s+1]>=s) res = s;
                    else s--;
                }
            }
        }

        System.out.println(res);
    }

}

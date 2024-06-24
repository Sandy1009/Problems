public class PrintMatrixInDiagonalPattern {

    public static void main(String[] ar) {

        int count = 0;
        int[][] mat = new int[3][3];

       // int[][] mat = {{2,3}};

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                mat[i][j] = ++count;
            }
        }
        int n = mat.length;
        int m = mat[0].length;

        int row = 0, col= 0;
        int index = 0;
        int[] res = new int[n*m];
        
        boolean up = true;

        while(index < n*m) {

            res[index++] = mat[row][col];

            if(up) {
                if(col == m-1) {
                    row++;
                    up = false;
                } else if(row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if(row == n-1) {
                    col++;
                    up = true;
                } else if(col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        for(int i=0; i<res.length; i++) {
            System.out.print(res[i]+"   ");
        }
    }

}

public class Test {

    public static void main(String[] ar) {
        int A = 2;
        int B = 20;
        int[] C = { 5, 3, 6, 1, 9 };
        int result = minPainters(A, B, C);
        System.out.println(result);
    }

    private static int minPainters(int B, int x, int[] C) {
        int count = 1;
        int pTime = x;

        for (int i = 0; i < C.length; i++) {
            int bTime = C[i] * B;

            if (bTime > x) {
                return -1; // Cannot complete painting within time x
            }

            if (pTime >= bTime) {
                pTime -= bTime;
            } else {
                count++;
                pTime = x - bTime; // Update pTime for the next painter
            }
        }

        return count;
    }

}

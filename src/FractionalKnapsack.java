/*
https://www.scaler.com/academy/mentee-dashboard/class/176793/assignment/problems/35883?navref=cl_tt_lst_nm
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    public static void main(String[] ar) {
        /*int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;*/
        /*int[] A = {16,3,3,6,7,8,17,13,7};
        int[] B = {3,10,9,18,17,17,6,16,13};
        int C = 11;*/

        int[] A = {3};
        int[] B = {20};
        int C = 17;

        System.out.println(solve(A, B, C));
    }

    static class T {
        int a;
        int b;
        double f;

        T(int a, int b) {
            this.a = a;
            this.b = b;
            this.f = (double)(a*1.0/b);
        }
    }

    public static int solve(int[] A, int[] B, int C) {

        int n = A.length;

        List<T> list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            list.add(new T(A[i], B[i]));
        }

        Collections.sort(list, new NewComparator());
        double res = 0;

        for(int i=0; i<n; i++) {
            T temp = list.get(i);

            if(temp.b <= C) {
                res += temp.a;
                C -= temp.b;
            } else {
                double frac = (C*1.0/temp.b);
                res += (frac*temp.a);
                C -= (frac * temp.b);
            }

            if(C == 0) break;
        }

        return (int) (res*100);

    }

    static class NewComparator implements Comparator<T> {
        @Override
        public int compare(T t1, T t2) {
            return Double.compare(t2.f, t1.f);
        }
    }
}

/**
 *
 */
public class NthCharacter {
    public static void main(String[] args) {

       /* String s = "111101";
        int r = 2;
        int n = 3;

        List<Integer> list = new ArrayList<>();
        int len = s.length();

        for(int i=0; i<len; i++) {
            list.add(s.charAt(i) - '0');
        }

        List<Integer> res = create(r, list);
        int x = res.get(n);

        System.out.println((char)(x+'0'));*/

        String s = "1100";
        int r = 2;
        int n = 3;

        int len = s.length();
        int totalLen = len * (1 << r); // Calculate total length after r iterations
        char result = findNthCharacter(s, r, n, totalLen);
        System.out.println(result);

    }

    public static char findNthCharacter(String s, int r, int n, int totalLen) {
        int position = (int) ((long) n * totalLen / s.length());

        for (int i = 0; i < r; i++) {
            if (s.charAt(position % s.length()) == '0') {
                position *= 2;
            } else {
                position = position * 2 + 1;
            }
        }

        return s.charAt(position % s.length());
    }

   /* private static List<Integer> create(int r, List<Integer> list) {
        if(r == 0) return list;

        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) == 0) {
                temp.add(0);
                temp.add(1);
            } else {
                temp.add(1);
                temp.add(0);
            }
        }
        r--;

        return create(r, temp);
    } */
}
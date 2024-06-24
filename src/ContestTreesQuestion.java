import java.util.ArrayList;
import java.util.List;

public class ContestTreesQuestion {

    public static void main(String[] ar) {
        TreeNode root = new TreeNode(21);
        root.left = new TreeNode(4);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(-1);
        root.left.right.right = new TreeNode(-1);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(-1);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(4);
        root.left.left.left.left = new TreeNode(6);
        root.left.left.left.right = new TreeNode(-1);

        int res = minHeight(root);
        System.out.println(res);
    }
    public static int minHeight(TreeNode A) {

        int minH = findMinDepth(A);
        int maxH = findMaxDepth(A);
        if(maxH == minH) return 0;

        int total = 0;
        List<Integer> list = new ArrayList<>();

        collectNodes(A, 0, maxH-1, list);
        for(int i : list) {
            total += i;
            //System.out.print(i+"  ");
        }
        return total;
    }

    private static void collectNodes(TreeNode root, int currentH, int height, List<Integer> list) {
        if(root == null) return;

        if(currentH == height) {
            if(root.left == null && root.right == null) list.add(root.data);
            return;
        }
        collectNodes(root.left, currentH + 1, height, list);
        collectNodes(root.right, currentH+1, height, list);
    }

    private static int findMaxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(findMaxDepth(root.left), findMaxDepth(root.right));
    }

    private static int findMinDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return 1+findMinDepth(root.right);
        if(root.right == null) return 1+findMinDepth(root.left);
        return 1+Math.min(findMinDepth(root.left), findMinDepth(root.right));
    }



}

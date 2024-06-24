/*
Given a binary tree with n nodes, find the number of pairs violating the BST property.
BST has the following properties:-
Every node is greater than its left child and less than its right child.
Every node is greater than the maximum value of in its left subtree and less than the minimum value in its right subtree.
The maximum in the left sub-tree must be less than the minimum in the right subtree.

input1:
n = 5
50 10 20 40 30

https://www.geeksforgeeks.org/problems/pairs-violating-bst-property--212515/1
 */

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

public class PairsViolatingBSTProperty {

    static int k = 0;

    public static void main(String[] ar) {

        int n = 5;
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(30);

        int[] arr = new int[n];
        inorder(arr, root);
        printArray(arr);

    }

    private static void inorder(int[] arr, TreeNode root) {
        if(root == null) return;

        arr[k++] = root.data;
        inorder(arr, root.left);
        inorder(arr, root.right);
    }

    public static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) System.out.print(arr[i]+"  ");
        System.out.println();
    }

}

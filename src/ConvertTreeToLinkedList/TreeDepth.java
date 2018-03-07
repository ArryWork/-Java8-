package ConvertTreeToLinkedList;

public class TreeDepth {
    /**
     * public class TreeNode {
     * int val = 0;
     * TreeNode left = null;
     * TreeNode right = null;
     * <p>
     * public TreeNode(int val) {
     * this.val = val;
     * <p>
     * }
     * <p>
     * }
     */
    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return left >= right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode5.left = treeNode7;
        TreeDepth t = new TreeDepth();
        t.treeDepth(treeNode1);

    }
}

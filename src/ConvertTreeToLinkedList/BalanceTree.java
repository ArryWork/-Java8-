package ConvertTreeToLinkedList;

public class BalanceTree {

    public class Hold{
        int n;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        Hold hold = new Hold();
        boolean flag = f(root,hold);
        return flag;
    }

    private boolean f(TreeNode root, Hold hold) {
        if (root==null){
            hold.n = 0;
            return true;
        }
        Hold l = new Hold();
        Hold r = new Hold();
        if (f(root.left,l)&&f(root.right,r)){
            if (l.n - r.n > 1|| r.n - l.n > 1) {
                return false;
            }
            hold.n += (l.n > r.n ? l.n:r.n) + 1;
            return true;
        }
        return false;
    }
}

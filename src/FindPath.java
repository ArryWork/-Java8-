import ConvertTreeToLinkedList.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Arry on 2017/11/15.
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
    ArrayList<ArrayList<Integer>> pathList = new ArrayList<>();
    if (root == null) {
        return pathList;
    }
    Stack<Integer> stack = new Stack<>();
    FindPath(root, target, stack, pathList);
    return pathList;
}

    private void FindPath(TreeNode root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> pathList) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i : path) {
                    list.add(i);
                }
                list.add(root.val);
                pathList.add(list);
            }
        }
        path.push(root.val);
        FindPath(root.left,target - root.val,path,pathList);
        FindPath(root.right, target - root.val, path,pathList);
        path.pop();

    }

}

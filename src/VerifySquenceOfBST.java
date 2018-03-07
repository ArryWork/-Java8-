import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * Created by Arry on 2017/11/15.
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length==0){
            return false;
        }
        int length = sequence.length;
        int root = sequence[length-1];
        int i = 0;
        for (;i < length-1; i++){
            if (sequence[i] > root){
                break;
            }
        }
        int j = i;
        for (;j < length-1; j++){
            if (sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        if (i > 0){
            left = VerifySquenceOfBST(Arrays.copyOf(sequence,i));
        }
        boolean right = true;
        if (i < length-1){
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence,i,length-1));
        }
        return left&&right;
    }

    public static void main(String[] args) {
        int[] t = {4,8,6,12,16,14,10};
        VerifySquenceOfBST v = new VerifySquenceOfBST();
        v.VerifySquenceOfBST(t);
    }
}

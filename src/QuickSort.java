/**
 * Created by Arry on 2017/11/6.
 */
public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        process(A,0,n-1);
        return A;
    }

    public void process(int[]A, int _left, int _right){
        int left = _left;
        int right = _right;
        int temp;
        if(left <= right) {
            temp = A[left];
            while (left != right) {
                while (right > left && A[right] >= temp) {
                    right--;
                }
                A[left] = A[right];
                while (left < right && A[left] <= temp) {
                    left++;
                }
                A[right] = A[left];
            }
            A[right] = temp;
            process(A, _left, left - 1);
            process(A, right + 1, _right);
        }
    }

    public static void main(String[] args) {
        int array[] = {7,3,8,1,2,6};
        System.out.println("排序之前：");
        for(int element : array){
            System.out.print(element+" ");
        }
        QuickSort q = new QuickSort();
        q.quickSort(array,6);

        System.out.println("\n排序之后：");
        for(int element : array){
            System.out.print(element+" ");
        }
    }
}
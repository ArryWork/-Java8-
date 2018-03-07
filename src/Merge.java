import java.util.Arrays;

/**
 * Created by Arry on 2017/11/3.
 */
public class Merge {

    public int[] mergeSort(int[] A, int length){
        sort(A,0,length-1);
        return A;
    }

    public void sort(int[] A, int left,int right ){
        if (left < right){
            int middle = (left + right)/2;
            sort(A,left,middle);
            sort(A,middle+1,right);
            merge(A,left,middle,right);
        }
    }

    void merge(int[] A, int left, int middle, int right){
        int[] temp = new int[A.length];
        int i = left;
        int j = middle+1;
        int k = left;
        while (i <= middle && j <= right){
            if ( A[i] < A[j] ){
                temp[k++] = A[i++];
            }else {
                temp[k++] = A[j++];
            }
        }
        //剩余未合并的部分
        while(i<=middle){
            temp[k++]=A[i++];
        }
        while(j<=right){
            temp[k++]=A[j++];

        }
        //将临时数组中的内容存储到原数组中
        while(left<=right){
            A[left]=temp[left++];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = new Merge().mergeSort(a,5);
        Arrays.stream(b).forEach(System.out::print);
    }
}

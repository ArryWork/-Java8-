package sort;

public class MergeSortRe {
    public int[] mergeSort(int[] array){

        return array;
    }
    public void inverse(int[] array, int start, int end){
        if (start==end){
            return;
        }else {
            int mid = (start+end)/2;
            int p = start;
            int q = mid;
            inverse(array,start,mid);
            inverse(array,mid+1,end);
            while (p<=mid&&q<=end){

            }
        }
    }
    public static void main(String[] args) {

    }
}
